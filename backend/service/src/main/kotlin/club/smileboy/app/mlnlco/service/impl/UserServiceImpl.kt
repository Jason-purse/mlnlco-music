package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint
import club.smileboy.app.commons.mlnlco.exceptions.DataException
import club.smileboy.app.commons.mlnlco.utils.*
import club.smileboy.app.mlnlco.model.entity.UserEntity
import club.smileboy.app.mlnlco.model.params.query.PageQuery
import club.smileboy.app.mlnlco.model.params.query.user.UserByPageQuery
import club.smileboy.app.mlnlco.model.params.query.user.UserQuery
import club.smileboy.app.mlnlco.model.params.store.user.DefaultUserStoreParam
import club.smileboy.app.mlnlco.model.params.store.user.SaveUserStoreParam
import club.smileboy.app.mlnlco.model.vo.DefaultUserVo
import club.smileboy.app.mlnlco.repository.UserRepository
import club.smileboy.app.mlnlco.service.DataDictService
import club.smileboy.app.mlnlco.service.UserService
import club.smileboy.app.mlnlco.service.queryassist.UserQueryAssist
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.stereotype.Service
import java.text.DateFormat
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 8:22
 * @description 用户服务 service
 **/
@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val dataDictService: DataDictService
) : UserService<UserQuery> {

    override fun findAllUsersByPage(query: UserQuery): Page<DefaultUserVo> {
        (query as UserByPageQuery).let { byPageQuery ->
            //  普通用户DataItem
            val dictDataItem = dataDictService.findNormalUserDataItem()
            val select: LambdaQueryWrapper<UserEntity> =
                UserQueryAssist.findAllUsersQueryAssist(byPageQuery, dictDataItem.id)
            return (query as PageQuery).getPageable().let { it ->

                val of = Page.of<UserEntity>(it.pageNumber.toLong(), it.pageSize.toLong())

                userRepository.selectPage(of, select).run {
                    val result = Page.of<DefaultUserVo>(current, size)

                    ElvisUtil.assertNotNullAndActionOrDefault(
                        result.records,
                        StreamUtil.doElementTypeMapAction(DefaultUserVo::class.java) {
                            // 时间国际化
                           it.createTimeStr = DateUtil.getLocaleDateString(it.createTime,RequestUtil.getRequestLocale())
                            it.updateTimeStr =DateUtil.getLocaleDateString(it.updateTime,RequestUtil.getRequestLocale())
                        },
                        LambdaFunctionUtil.supplier(emptyList())
                    ).also { data ->
                        result.records = data
                    }

                    result.total = total
                    result
                }
            }
        }
    }

    override fun findUserInfoById(id: Long): DefaultUserVo {
        return ElvisUtil.assertNotNullAndActionOrThrow(
            userRepository.selectOne(UserQueryAssist.createIdQuery(id)),
            BeanUtils.doElementTypeMap(DefaultUserVo::class.java),
            LambdaFunctionUtil.supplier(
                DataException("[ $id ] can't match one data !!")
            )
        )
    }


    override fun updateUserInfoByIdAndParams(id: Long, userStoreParam: DefaultUserStoreParam): DefaultUserVo {
        return ElvisUtil.assertNotNullOrThrow(userRepository.selectById(id)) {
            ExceptionUtil.exception(
                DataException.CODE,
                ErrorMessageConstraint.USER_INFO_ZERO,
                RequestUtil.getRequestLocale()
            )
        }.let {
            val updateData = BeanUtils.transformFrom(userStoreParam, UserEntity::class.java)
            BeanUtils.updateProperties(updateData!!, it)
            // 尝试更新
            userRepository.updateById(it)
            BeanUtils.transformFrom(it, DefaultUserVo::class.java)!!
        }
    }

    override fun insertUserInfoByParams(userStoreParam: SaveUserStoreParam) {
        userRepository.selectOne(UserQueryAssist.createEmailQuery(userStoreParam.email)) ?: BeanUtils.transformFrom(
            userStoreParam,
            UserEntity::class.java
        )!!.apply {
            // 其他信息 ..
            // 用户角色 ..
            val normalDataItem = dataDictService.findNormalUserDataItem()
            userType = normalDataItem.id.toString()
            createTime = Date()
            updateTime = createTime
            createTimeStr = DateFormat.getDateTimeInstance().format(createTime)
            updateTimeStr = createTimeStr

            userRepository.insert(this)
            return
        }

        throw ExceptionUtil.exception(DataException.CODE,ErrorMessageConstraint.USER_INFO_ONE,RequestUtil.getRequestLocale())
    }

    override fun deleteUserInfoById(id: Long) {
        userRepository.deleteById(id)
    }
}