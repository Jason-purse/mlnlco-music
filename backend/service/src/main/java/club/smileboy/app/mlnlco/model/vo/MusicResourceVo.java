package club.smileboy.app.mlnlco.model.vo;
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 8:47
 * @description 音乐媒体资源Vo
 **/
public class MusicResourceVo extends DefaultMediaResourceVo {
    /**
     * 歌手
     */
    private String singer;

    /**
     * 专辑
     */
    private String album;

    /**
     * 音乐媒体类型 【 对应字典ID ]
     */
    private String musicMediaType;

}
