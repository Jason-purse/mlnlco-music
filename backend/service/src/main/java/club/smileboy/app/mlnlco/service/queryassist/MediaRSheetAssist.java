package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.mlnlco.model.entity.MediaRSheetEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:14
 * @description media and sheet relationship assist
 **/
public class MediaRSheetAssist {
    /**
     * 创建一个根据mediaId 和 sheetId的Query
     * @param mediaId mediaId
     * @param sheetId sheetId
     * @return Query 实例
     */
    public static LambdaQueryWrapper<MediaRSheetEntity> createMediaIdAndSheetIdQueryAssist(Long mediaId,Long sheetId) {
        return new LambdaQueryWrapper<>(MediaRSheetEntity.class)
                .eq(MediaRSheetEntity::getMediaId,mediaId)
                .eq(MediaRSheetEntity::getSheetId,sheetId);
    }

    /**
     * 创建一个 sheetId Query
     * @param sheetId sheet Id
     * @return Query 实例
     */
    public static Wrapper<MediaRSheetEntity> createSheetIdQuery(long sheetId) {
        return new LambdaQueryWrapper<>(MediaRSheetEntity.class).eq(MediaRSheetEntity::getSheetId,sheetId);
    }
}
