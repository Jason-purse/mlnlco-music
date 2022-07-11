package club.smileboy.app.mlnlco.model.params.query.resource.music

import club.smileboy.app.mlnlco.model.params.query.PageQuery
import club.smileboy.app.mlnlco.model.params.query.PageQuery.Companion.withPageQuery
import club.smileboy.app.mlnlco.model.params.query.resource.MediaQuery
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 10:07
 * @description 默认媒体查询及分页Query
 **/
class DefaultMediaQueryAndPage(private val musicQuery: MediaQuery, private val pageQuery: PageQuery): MediaQuery by musicQuery,PageQuery{

    constructor(musicQuery: MediaQuery,pageable: Pageable): this(musicQuery,pageable.withPageQuery())

    override fun getPageable(): Pageable {
        return pageQuery.getPageable()
    }
}

fun main() {
    println(DefaultMediaQueryAndPage(MusicQuery(), PageRequest.of(1, 10)))
}