package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint
import club.smileboy.app.commons.mlnlco.exceptions.DataException
import club.smileboy.app.commons.mlnlco.exceptions.ViolationException
import club.smileboy.app.commons.mlnlco.utils.*
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType.Companion.SYSTEM_CHILD_TYPE
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType.Companion.SYSTEM_TYPE
import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity
import club.smileboy.app.mlnlco.model.params.query.dict.DataDictQuery
import club.smileboy.app.mlnlco.model.params.query.dict.DataDictStoreParam
import club.smileboy.app.mlnlco.model.params.query.dict.DefaultDataDictQuery
import club.smileboy.app.mlnlco.model.vo.DataDictVo
import club.smileboy.app.mlnlco.repository.DataDictRepository
import club.smileboy.app.mlnlco.service.DataDictService
import club.smileboy.app.mlnlco.service.queryassist.DictQueryAssist
import club.smileboy.app.mlnlco.util.isNotBlankForBool
import club.smileboy.app.mlnlco.util.isNotEmptyForBool
import club.smileboy.app.mlnlco.util.isNotNullForBool
import club.smileboy.app.mlnlco.util.toPage
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:28
 * @description 数据字典实现
 **/
@Service
class DataDictServiceImpl(private val dictRepository: DataDictRepository) : DataDictService {

    override fun findAllDataItemsByDataType(dataType: String): List<DataDictVo.DataDictItemVo> {
        return dictRepository.selectList(DictQueryAssist.createDataTypeQuery(listOf(dataType))).run {
            isNotNullForBool()?.let {
                this.map { ele ->
                    DataDictVo.DataDictItemVo.of(ele.id, ele.dataType, ele.title, ele.dataItem)
                }
            } ?: emptyList()
        }
    }

    /**
     * 查询一个DataType 数据及其所有归属于它的DataItem
     */
    private fun findAllDataItemsByDataTypeOrSystemDataItem(
        dataType: String,
        dataItem: String
    ): List<DataDictionaryEntity> {
        return dictRepository.selectList(DictQueryAssist.createDataTypeAndSystemDataItemQuery(dataType, dataItem))
    }

    /**
     * 查询所有的DataItems
     *
     * 分页维度是依据 data_type
     * 但是本身存储的数据是data_item
     * 所以当没有data_type -> []
     * 否则 data_type -> in 查询所有的data_items ...
     * @param dataType data type
     * @param pageable 分页参数
     */
    private fun findAllDataItemsByPage(dataType: String?, pageable: Pageable): Page<DataDictionaryEntity> {
        return ElvisUtil.assertNotNullAndActionOrDefault(dataType, {
            // 则直接匹配即可
            Page.of<DataDictionaryEntity?>(1, pageable.pageSize.toLong()).apply {
                records = ElvisUtil.assertNotNullOrDefault(
                    findAllDataItemsByDataTypeOrSystemDataItem(
                        dataType!!,
                        dataType
                    )
                ) { emptyList() }
                // 总数就是查询出来的数据 ...
                // 有就是一页,否则 0
                total = records.size.toLong()
            }
        }) {
            // 根据dataType 分页
            val page = dictRepository.selectPage(
                Page.of(
                    pageable.pageNumber.toLong(),
                    pageable.pageSize.toLong()
                ), DictQueryAssist.createSystemTypeQuery()
            )
            if (page.records != null && page.size > 0) {
                ElvisUtil.assertListNotEmptyAndActionOrDefault(
                    dictRepository.selectList(
                        DictQueryAssist.createDataTypeQuery(page.records.map { it.dataItem })
                    ), {
                        mutableListOf<DataDictionaryEntity?>().apply {
                            addAll(it)
                            addAll(page.records)
                        }
                    }, { page.records })
                    .also {
                        page.records = it
                    }
            }
            page
        }
    }

    override fun findDataItemByDataTypeAndDataItemCode(dataType: String, dataItemCode: String): DataDictionaryEntity {
        return dictRepository.selectOne(DictQueryAssist.createDataTypeAndItemCodeQuery(dataType, dataItemCode))
    }

    override fun findNormalUserDataItem(): DataDictionaryEntity {
        return findDataItemByDataTypeAndDataItemCode(
            GenericDataDictDataType.USER_TYPE,
            GenericDataDictDataItem.USER_TYPE_NORMAL_USER
        )
    }

    override fun findAllDataDictItemsByQueryAndPage(
        dataDictQuery: DataDictQuery,
        pageable: Pageable
    ): Page<DataDictVo> {
        val defaultDataDictQuery = dataDictQuery as DefaultDataDictQuery
        return findAllDataItemsByPage(defaultDataDictQuery.dataType, pageable).run {
            // 最终结果
            val page = Page.of<DataDictVo>(current, size)
            // 从这里可以看出,DataDict 只能只增不减 ...
            // 转化结果
            val result: List<DataDictVo> = ElvisUtil.assertListNotEmptyAndActionOrDefault(records, { list ->
                val groupBy: Map<String, List<DataDictionaryEntity>> =
                    list.groupBy { if (it.dataType == SYSTEM_TYPE) SYSTEM_TYPE else SYSTEM_CHILD_TYPE }
                // 去重 所有字典类型Map ...
                val allDataTypeElements: Map<String, DataDictionaryEntity> =
                    groupBy[SYSTEM_TYPE]!!.associateBy { it.dataItem }

                // 所有字典类型进行 transform ...
                groupBy[SYSTEM_CHILD_TYPE]!!.groupBy { it.dataType }.map { (dataType, list) ->
                    val element = allDataTypeElements[dataType]!!
                    DataDictVo.of(
                        element.id,
                        element.dataType,
                        element.title,
                        ElvisUtil.assertListNotEmptyAndActionOrDefault(list, StreamUtil.doAction {
                            DataDictVo.DataDictItemVo.of(it.id, it.dataType, it.title, it.dataItem)
                        }) { emptyList() }
                    )
                }
            }, { emptyList() })
            page.total = total
            page.records = result
            page
        }
    }

    override fun findAllDataDictTypesByPage(pageable: Pageable): Page<DataDictVo> {
        return dictRepository.selectPage(pageable.toPage(), DictQueryAssist.createSystemTypeQuery()).run {
            pageable.toPage<DataDictVo>().let {
                it.records = (records.isNotEmptyForBool()?.let {
                    records.map { ele ->
                        DataDictVo.of(ele.id, ele.dataItem, ele.title, emptyList())
                    }
                }) ?: emptyList<DataDictVo>()
                it.total = total
                it
            }
        }
    }

    override fun updateDataDictInfoByParams(id: Long, dataDictStoreParam: DataDictStoreParam) {

        val title = ErrorMessageConstraint.evaluateMessageOrNullByLocale(
            RequestUtil.getRequestLocale(),
            ErrorMessageConstraint.TITLE.messageCode
        )
        // check
        dataDictStoreParam.title.isNotBlankForBool() ?: ExceptionUtil.exception(
            ViolationException.CODE,
            ErrorMessageConstraint.DATA_VIOLATION_TEMPLATE_EMPTY,
            RequestUtil.getRequestLocale(),
        )

        dictRepository.selectById(id)?.apply {
            BeanUtils.updateProperties(dataDictStoreParam, this)
            dictRepository.updateById(this)
        } ?: ExceptionUtil.exception(
            DataException.CODE,
            ErrorMessageConstraint.DATA_EMPTY,
            RequestUtil.getRequestLocale(),
            "$title"
        )
    }
}