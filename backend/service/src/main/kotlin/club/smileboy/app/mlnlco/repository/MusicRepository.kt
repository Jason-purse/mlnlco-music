package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.MusicEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 10:29
 * @description 音乐仓库bean
 **/
@Mapper
interface MusicRepository : BaseMapper<MusicEntity>