package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.vo.ResourceVo
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 8:31
 * @description 资源接口列表
 **/
@Api("资源接口列表")
@RestController
@RequestMapping("api/mlnlco/v1/resource")
class ResourceController {

    /**
     * 资源仪表盘
     *
     * 返回 资源分类 + 总数
     *      图标资源分类 + 总数
     *      日增长资源曲线 ....
     *
     */
    @GetMapping
    fun dashboard(): ResourceVo {
        TODO()
    }

}