package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.MediaRSheetEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 18:32
 * @description 媒体和 Sheet 之间的关系
 *  1. sheet 指的是
 *      - 歌单
 *      - 收藏
 *      - 影视集
 **/
@Mapper
interface MediaRSheetRepository : BaseMapper<MediaRSheetEntity> {


}