package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity

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
    fun findAllDataItemsByDataType(dataType: String): List<DataDictionaryEntity>

    /**
     * 根据数据类型约束和数据项代码查询一个唯一数据项
     */
    fun findDataItemByDataTypeAndDataItemCode(dataType: String,dataItemCode: String): DataDictionaryEntity

    /**
     * 获取普通用户的DataItem
     */
    fun findNormalUserDataItem(): DataDictionaryEntity
}