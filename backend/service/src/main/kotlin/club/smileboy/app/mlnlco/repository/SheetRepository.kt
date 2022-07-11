package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.MediaSheetEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:53
 * @description sheet repository
 **/
@Mapper
interface SheetRepository: BaseMapper<MediaSheetEntity> {
}