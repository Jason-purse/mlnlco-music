package club.smileboy.app.mlnlco.model.params.query

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.data.domain.Pageable

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:47
 * @description 分页查询参数
 **/
@ApiModel("pageQuery")
interface PageQuery {

    /**
     * 获取查询分页参数
     */
    @ApiModelProperty("分页参数")
    fun getPageable(): Pageable

    /**
     * 可以给定一个Pageable 转换为 PageQuery
     * @param pageable 分页参数
     * @return pageParam 分页查询参数
     */
    fun withPageable(pageable: Pageable): PageQuery {
        return pageable.withPageQuery()
    }


    companion object {
        /**
         * 将Pageable 转变为PageQuery
         */
        fun Pageable.withPageQuery(): PageQuery {
            return DefaultPageQuery(this)
        }
    }

    /**
     * 默认的Page Query
     */
    private class DefaultPageQuery(private val pageable: Pageable): PageQuery {

        override fun getPageable(): Pageable = pageable

        override fun withPageable(pageable: Pageable) = DefaultPageQuery(pageable)
    }

}