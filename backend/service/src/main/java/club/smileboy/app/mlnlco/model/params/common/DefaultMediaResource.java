package club.smileboy.app.mlnlco.model.params.common;

import lombok.Data;
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 9:32
 * @description 默认媒体资源抽象
 **/
@Data
public abstract class DefaultMediaResource implements MediaResource {
    /**
     * 媒体类型
     */
    private String mediaType;

    /**
     * 媒体名称(音乐 / 视频名称)
     */
    private String mediaName;
}
