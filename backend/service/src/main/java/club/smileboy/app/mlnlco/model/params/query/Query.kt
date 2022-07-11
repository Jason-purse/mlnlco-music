package club.smileboy.app.mlnlco.model.params.query

import club.smileboy.app.mlnlco.model.params.Param
import club.smileboy.app.mlnlco.model.params.query.user.UserQuery
import org.springframework.data.domain.Pageable

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:45
 * @description 查询参数 抽象
 **/
interface Query : Param {

    /**
     * 可以给定一个Pageable 转换为 PageQuery
     * @param pageable 分页参数
     */
    fun withPageable(pageable: Pageable): PageQuery
}