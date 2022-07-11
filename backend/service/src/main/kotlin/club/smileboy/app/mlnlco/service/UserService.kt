package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.params.query.Query
import club.smileboy.app.mlnlco.model.params.store.user.DefaultUserStoreParam
import club.smileboy.app.mlnlco.model.params.store.user.SaveUserStoreParam
import club.smileboy.app.mlnlco.model.vo.DefaultUserVo
import com.baomidou.mybatisplus.extension.plugins.pagination.Page

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:44
 * @description 用户 service
 **/
interface UserService<T: Query> {

    /**
     * 根据条件查询所有用户信息
     * @param query 查询条件,包含分页参数
     */
    fun findAllUsersByPage(query: T): Page<DefaultUserVo>

    /**
     * 根据 id 查询一个用户信息
     * @param id 用户id
     */
    fun findUserInfoById(id: Long): DefaultUserVo

    /**
     * 根据用户id 和 用户其他参数 更新用户信息
     * @param id 用户id
     * @param userStoreParam 用户需要更新的其他参数
     */
    fun updateUserInfoByIdAndParams(id: Long, userStoreParam: DefaultUserStoreParam): DefaultUserVo

    /**
     * 根据参数信息保存一个用户
     * @param userStoreParam 用户参数信息
     * @return 保存结果
     */
    fun insertUserInfoByParams(userStoreParam: SaveUserStoreParam)

    /**
     * 通过id删除一个用户信息
     * @param id id
     * @return 删除结果
     */
    fun deleteUserInfoById(id: Long)
}