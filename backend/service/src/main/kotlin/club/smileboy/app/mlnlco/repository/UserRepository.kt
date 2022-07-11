package club.smileboy.app.mlnlco.repository

import club.smileboy.app.mlnlco.model.entity.UserEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 0:13
 * @description 用户仓库
 **/
@Mapper
interface UserRepository : BaseMapper<UserEntity>