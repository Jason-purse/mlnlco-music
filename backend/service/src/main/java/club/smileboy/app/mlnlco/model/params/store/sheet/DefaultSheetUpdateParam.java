package club.smileboy.app.mlnlco.model.params.store.sheet;

import lombok.Data;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 22:43
 * @description Sheet 更新参数
 **/
@Data
public class DefaultSheetUpdateParam implements SheetStoreParam {

    /**
     * 描述
     */
    private String description;

    /**
     * 图片链接
     */
    private String imageUrl;

    /**
     * sheet name
     */
    private String sheetName;


    /**
     * 歌单类型(enum)
     * @see club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem#SHEET_TYPE_PLAYLIST ....
     */
    private String sheetType;

}
