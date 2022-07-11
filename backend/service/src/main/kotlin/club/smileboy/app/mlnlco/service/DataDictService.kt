package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity
import club.smileboy.app.mlnlco.model.params.query.dict.DataDictQuery
import club.smileboy.app.mlnlco.model.params.query.dict.DataDictStoreParam
import club.smileboy.app.mlnlco.model.vo.DataDictVo
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:28
 * @description 数据字典
 **/
interface DataDictService {
    /**
     * 根据数据类型约束查询 数据项
     * @param dataType 数据类型字符串 - 使用枚举表示
     */
    fun findAllDataItemsByDataType(dataType: String): List<DataDictVo.DataDictItemVo>

    /**
     * 根据数据类型约束和数据项代码查询一个唯一数据项
     */
    fun findDataItemByDataTypeAndDataItemCode(dataType: String,dataItemCode: String): DataDictionaryEntity

    /**
     * 获取普通用户的DataItem
     */
    fun findNormalUserDataItem(): DataDictionaryEntity

    /**
     * 根据data type 进行 dataItem查询
     * @param dataDictQuery 数据字典查询
     * @param pageable 分页参数
     */
    fun findAllDataDictItemsByQueryAndPage(dataDictQuery: DataDictQuery,pageable: Pageable): Page<DataDictVo>

    /**
     * 分页查询所有的DataTypes
     * @param pageable 分页参数
     * @return 所有的DataTypes info
     */
    fun findAllDataDictTypesByPage(pageable: Pageable): Page<DataDictVo>

    /**
     * 根据id 更新一个data type  / item
     * 本质上只能够更新 title  ...
     */
    fun updateDataDictInfoByParams(id: Long, dataDictStoreParam: DataDictStoreParam)
}