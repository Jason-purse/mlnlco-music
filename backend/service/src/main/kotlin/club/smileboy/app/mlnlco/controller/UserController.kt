package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.params.query.user.UserQuery
import club.smileboy.app.mlnlco.model.params.query.user.DefaultUserQuery
import club.smileboy.app.mlnlco.model.params.query.user.UserByPageQuery
import club.smileboy.app.mlnlco.model.params.store.user.DefaultUserStoreParam
import club.smileboy.app.mlnlco.model.params.store.user.SaveUserStoreParam
import club.smileboy.app.mlnlco.model.vo.DefaultUserVo
import club.smileboy.app.mlnlco.model.vo.UserVo
import club.smileboy.app.mlnlco.service.UserService
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 22:15
 * @description 用户信息 接口
 **/
@RestController
@RequestMapping("api/mlnlco/v1/user")
class UserController(private val userService: UserService<UserQuery>) {


    /**
     * 根据查询条件查询用户信息 且分页 ...
     */
    @GetMapping("all")
    fun findAllUserInfosByQueryAndPage(userQuery: DefaultUserQuery,pageable: Pageable): Page<out UserVo> {
        return userService.findAllUsersByPage(UserByPageQuery(userQuery,pageable));
    }

    /**
     * 获取用户详情信息
     * @param id 用户id
     * @return userVo 用户信息
     */
    @GetMapping("{id}")
    fun findUserInfoById(@PathVariable("id") id: Long) : DefaultUserVo {
        return userService.findUserInfoById(id)
    }

    /**
     * 更新一个用户信息
     * @param id 用户id
     * @param userStoreParam 用户更新参数
     * @return userVo 用户更新后的信息
     */
    @PutMapping("{id}")
    fun updateUserInfoByIdAndParams(@PathVariable("id") id: Long,@RequestBody userStoreParam: DefaultUserStoreParam): DefaultUserVo {
        return userService.updateUserInfoByIdAndParams(id,userStoreParam);
    }

    /**
     * 新增一个用户信息
     * @param userStoreParam 新增用户的信息
     */
    @PostMapping
    fun insertUserInfoByParams(@RequestBody userStoreParam: SaveUserStoreParam) {
        userService.insertUserInfoByParams(userStoreParam);
    }

    /**
     * 删除一个用户信息
     */
    @DeleteMapping("{id}")
    fun deleteUserInfoById(@PathVariable("id") id: Long) {
        userService.deleteUserInfoById(id)
    }

}