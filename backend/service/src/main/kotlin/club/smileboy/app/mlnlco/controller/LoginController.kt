package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.params.query.user.UserQuery
import club.smileboy.app.mlnlco.model.params.trans.login.DefaultLoginParam
import club.smileboy.app.mlnlco.model.params.trans.login.LoginParam
import club.smileboy.app.mlnlco.model.vo.UserVo
import club.smileboy.app.mlnlco.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 22:07
 * @description 用户登录接口,包含了 管理员 / 用户登录接口 ....
 **/
@Api("用户登录接口")
@RestController
@RequestMapping("api/mlnlco/login/v1")
class LoginController(private val userService: UserService<UserQuery>) {

    /**
     * 用户登录 / 区分管理员和用户登录 ...
     */
    @PostMapping("login")
    fun login(@RequestBody loginParam: DefaultLoginParam): UserVo {
        if (loginParam.userType == GenericDataDictDataItem.USER_TYPE_NORMAL_USER) {
            return userLogin(loginParam)
        }
        return adminLogin(loginParam)
    }

    private fun userLogin(loginParam: LoginParam): UserVo {
        TODO()
    }

    private fun adminLogin(loginParam: LoginParam): UserVo {
        TODO()
    }
}