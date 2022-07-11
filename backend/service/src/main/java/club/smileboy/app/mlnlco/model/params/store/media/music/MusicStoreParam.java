package club.smileboy.app.mlnlco.model.params.store.media.music;

import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem;
import club.smileboy.app.mlnlco.model.params.store.StoreParam;
import club.smileboy.app.mlnlco.model.params.store.media.MediaStoreParam;
import lombok.Data;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 13:03
 * @description 音频(音乐)更新参数
 **/
@Data
public class MusicStoreParam implements MediaStoreParam, StoreParam {

    /**
     * 歌曲描述
     */
    private String description;

    /**
     * 歌词uri
     * TODO
     */
    private String lyricsUri;


    @Override
    public String getMediaStoreType() {
        return GenericDataDictDataItem.MEDIA_TYPE_AUDIO;
    }
}
