package club.smileboy.app.mlnlco.model.params.store.media;

import lombok.Data;

/**
 * 媒体和sheet 关系 删除 param
 */
@Data
public class MSRelationShipDeleteParam implements MediaStoreParam {
    /**
     * 媒体存储类型
     */
    private String mediaStoreType;

    /**
     * 媒体id
     */
    private Long mediaId;

    /**
     * sheet id
     */
    private Long sheetId;
}
