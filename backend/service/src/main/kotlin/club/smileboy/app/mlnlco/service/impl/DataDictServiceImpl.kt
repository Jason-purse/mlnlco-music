package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType
import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity
import club.smileboy.app.mlnlco.repository.DataDictRepository
import club.smileboy.app.mlnlco.service.DataDictService
import club.smileboy.app.mlnlco.service.queryassist.DictQueryAssist
import org.springframework.stereotype.Service

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:28
 * @description 数据字典实现
 **/
@Service
class DataDictServiceImpl(private val dictRepository: DataDictRepository) : DataDictService {
    override fun findAllDataItemsByDataType(dataType: String): List<DataDictionaryEntity> {
        return dictRepository.selectList(DictQueryAssist.createDataTypeQuery(dataType))
    }

    override fun findDataItemByDataTypeAndDataItemCode(dataType: String, dataItemCode: String): DataDictionaryEntity {
        return dictRepository.selectOne(DictQueryAssist.createDataTypeAndItemCodeQuery(dataType,dataItemCode))
    }

    override fun findNormalUserDataItem(): DataDictionaryEntity {
        return findDataItemByDataTypeAndDataItemCode(GenericDataDictDataType.USER_TYPE,GenericDataDictDataItem.USER_TYPE_NORMAL_USER)
    }
}