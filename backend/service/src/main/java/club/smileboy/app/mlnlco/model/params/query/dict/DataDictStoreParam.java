package club.smileboy.app.mlnlco.model.params.query.dict;

import club.smileboy.app.mlnlco.model.params.store.StoreParam;
/**
 * @author FLJ
 * @date 2022/7/11
 * @time 11:48
 * @Description 数据字典存储参数
 */
public interface DataDictStoreParam extends StoreParam {
    /**
     * 存储类型 ...
     */
    String getDataDictStoreType();

    /**
     * 获取Title
     */
    String getTitle();

    String getDataType();

    String getDataItem();
}
