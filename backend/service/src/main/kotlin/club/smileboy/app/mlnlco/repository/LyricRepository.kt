package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.LyricsEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author FLJ
 * @date 2022/7/11
 * @time 12:37
 * @Description 歌词仓库
 */
@Mapper
interface LyricRepository: BaseMapper<LyricsEntity> {


}