package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.mlnlco.model.entity.MediaSheetEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jetbrains.annotations.Nullable;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:55
 * @description sheet assist
 **/
public class SheetAssist {
    /**
     * 根据sheet Id 创建一个Query
     * @param sheetTypeId sheet type ref id
     * @return Query 实例
     */
    public static Wrapper<MediaSheetEntity> findAllSheetInfoQueryAssist(long sheetTypeId) {
        return new LambdaQueryWrapper<>(MediaSheetEntity.class).eq(MediaSheetEntity::getSheetTypeId,sheetTypeId);
    }

    /**
     * 根据sheet Name 和 当前登录用户id 创建一个Query
     * @param sheetName sheet name
     * @param userId user Id
     * @return Query 实例
     */
    public static Wrapper<MediaSheetEntity> createSheetNameAndCreateIdQuery(String sheetName, @Nullable Long userId) {
        return new LambdaQueryWrapper<>(MediaSheetEntity.class).eq(MediaSheetEntity::getSheetName,sheetName)
                .eq(MediaSheetEntity::getUserId,userId);
    }
}
