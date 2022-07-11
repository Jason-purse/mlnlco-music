package club.smileboy.app.mlnlco.model.params.query.resource.music;

import club.smileboy.app.mlnlco.model.params.common.DefaultMediaResource;
import club.smileboy.app.mlnlco.model.params.query.PageQuery;
import club.smileboy.app.mlnlco.model.params.query.resource.MediaQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Pageable;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 9:31
 * @description 媒体查询
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MusicQuery extends DefaultMediaResource implements MediaQuery {

    /**
     * 歌手
     */
    private String singer;

    /**
     * 专辑
     */
    private String album;


    /**
     * 音乐媒体类型
     */
    private String musicMediaType;

    @NotNull
    @Override
    public PageQuery withPageable(@NotNull Pageable pageable) {
        return new DefaultMediaQueryAndPage(this,pageable);
    }
}

