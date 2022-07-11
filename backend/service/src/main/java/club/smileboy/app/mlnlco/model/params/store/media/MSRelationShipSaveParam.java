package club.smileboy.app.mlnlco.model.params.store.media;

import lombok.Data;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:04
 * @description 音频 和 Sheet 之间的关系
 *              也可以说是音乐 / 视频 和 Sheet之间的关系
 **/
@Data
public class MSRelationShipSaveParam implements MSRelationStoreParam {

    /**
     * media title
     */
    private String mediaTitle;

    /**
     * sheet 类型
     */
    private Long sheetType;

    /**
     * sheet id
     */
    private Long sheetId;

    /**
     * media id
     */
    private Long mediaId;

    /**
     * 媒体类型
     * [数据字典对应的Item 的id]
     */
    private Long  mediaType;

    /**
     * 媒体存储类型
     * @see club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem#MEDIA_TYPE_AUDIO ...
     */
    private String mediaStoreType;
}
