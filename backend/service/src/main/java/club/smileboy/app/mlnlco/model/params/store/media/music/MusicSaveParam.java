package club.smileboy.app.mlnlco.model.params.store.media.music;

import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem;
import club.smileboy.app.mlnlco.model.params.store.StoreParam;
import club.smileboy.app.mlnlco.model.params.store.media.MediaStoreParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 11:00
 * @description 音乐存储参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicSaveParam implements MediaStoreParam,StoreParam {

    /**
     * 名称 [暂时不能为空 ]
     * 后续通过音频库解析
     */
    @NotBlank(message="[名称]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("音乐名称")
    @Length(max= 127,message="编码长度不能超过127")
    private String name;

    /**
     * 歌手
     */
    @NotBlank(message="[歌手]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("歌手")
    @Length(max= 127,message="编码长度不能超过127")
    private String singer;
    /**
     * 专辑
     */
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("专辑")
    @Length(max= 127,message="编码长度不能超过127")
    private String album;

    /**
     * 歌曲简介
     */
    @Size(max= 2048,message="编码长度不能超过2048")
    @ApiModelProperty("歌曲简介")
    @Length(max= 2048,message="编码长度不能超过2,048")
    private String description;
    /**
     * 歌曲图片
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("歌曲图片")
    @Length(max= 255,message="编码长度不能超过255")
    private String imageUrl;
    /**
     * 歌曲时长
     * 必须大于30秒
     */
    @NotNull(message="[歌曲时长]不能为空")
    @Min(message = "歌曲时常必须大于60",value = 30)
    @ApiModelProperty("歌曲时长")
    private Long duration;
    /**
     * 歌曲链接
     */
    @Size(max= 512,message="编码长度不能超过255")
    @ApiModelProperty("歌曲链接")
    @Length(max= 512,message="编码长度不能超过255")
    private String url;

    /**
     * 歌词id
     * 待修改
     */
    @ApiModelProperty("歌词id")
    private Object lyricsId;

    /**
     * 歌曲类型,例如 AAC,mp3,hls
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("歌曲类型,例如 AAC,mp3,hls")
    @Length(max= 50,message="编码长度不能超过50")
    private String mediaType;

    @Override
    public String getMediaStoreType() {
        return GenericDataDictDataItem.MEDIA_TYPE_AUDIO;
    }
}
