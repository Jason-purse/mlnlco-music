package club.smileboy.app.mlnlco.model.params.store.media;
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 20:58
 * @description media and sheet relationShip ...
 **/
public interface MSRelationStoreParam extends MediaStoreParam {
    /**
     * sheet 类型
     * @see club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem#SHEET_TYPE_PLAYLIST ...
     */
    String getSheetType();
}
