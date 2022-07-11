package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.commons.mlnlco.exceptions.AssertException;
import club.smileboy.app.commons.mlnlco.utils.AssertUtil;
import club.smileboy.app.commons.mlnlco.utils.ExceptionUtil;
import club.smileboy.app.commons.mlnlco.utils.StringUtil;
import club.smileboy.app.mlnlco.model.entity.MusicEntity;
import club.smileboy.app.mlnlco.model.params.query.resource.music.MusicQuery;
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicSaveParam;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.util.StringUtils;

import java.util.Locale;

import static club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint.DATA_VIOLATION_EMPTY;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 10:36
 * @description music 查询助手
 **/
public class MusicQueryAssist {
    /**
     * 通过查询参数发现所有音乐信息
     *
     * @param musicQuery 音乐查询条件
     * @return Query 对象
     */
    public static LambdaQueryWrapper<MusicEntity> findAllMusicInfoQueryAssist(MusicQuery musicQuery) {
        LambdaQueryWrapper<MusicEntity> queryWrapper = new LambdaQueryWrapper<>(MusicEntity.class);
        if (StringUtils.hasText(musicQuery.getMusicMediaType())) {
            queryWrapper.eq(MusicEntity::getMediaType, musicQuery.getMusicMediaType().trim());
        }
        if (StringUtils.hasText(musicQuery.getSinger())) {
            queryWrapper.eq(MusicEntity::getSinger, musicQuery.getSinger().trim());
        }
        if (StringUtils.hasText(musicQuery.getMediaName())) {
            queryWrapper.likeLeft(MusicEntity::getName, musicQuery.getMediaName().trim());
        }
        if (StringUtils.hasText(musicQuery.getAlbum())) {
            queryWrapper.like(MusicEntity::getAlbum, musicQuery.getAlbum().trim());
        }
        return queryWrapper;
    }

    /**
     * 创建一个保存音乐媒体信息的Query 对象
     * @param musicStoreParam 音乐存储媒体参数
     * @param locale locale
     * @return Query 实例
     */
    public static Wrapper<MusicEntity> createSaveMusicInfoQuery(@NotNull MusicSaveParam musicStoreParam, @Nullable Locale locale) {
        AssertUtil.assertLogicTrue(
                StringUtil.allIsNotBlank(musicStoreParam.getSinger(), musicStoreParam.getAlbum(), musicStoreParam.getName()),
                () -> {
                    // 仅仅做校验 ...
                    // 不能为空 ...
                    return ExceptionUtil.exception(AssertException.CODE, DATA_VIOLATION_EMPTY);
                }
        );

        return new LambdaQueryWrapper<>(MusicEntity.class)
                .eq(MusicEntity::getSinger, musicStoreParam.getSinger())
                .eq(MusicEntity::getAlbum, musicStoreParam.getAlbum().trim())
                .eq(MusicEntity::getName, musicStoreParam.getName().trim());
    }
}
