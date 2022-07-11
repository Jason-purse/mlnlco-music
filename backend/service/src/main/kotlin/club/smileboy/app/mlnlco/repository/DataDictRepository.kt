package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:27
 * @description 数据字典
 **/
@Mapper
interface DataDictRepository: BaseMapper<DataDictionaryEntity>