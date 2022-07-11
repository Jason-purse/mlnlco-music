package club.smileboy.app.mlnlco.model.params.query.user

import club.smileboy.app.mlnlco.model.params.query.PageQuery
import lombok.Data
import lombok.Getter
import org.springframework.data.domain.Pageable
import java.util.*

/**
 * 基本用户查询Query ...
 */
class DefaultUserQuery (
    override val nickName: String? = null, override val userName: String? = null,
    override val createTime: Date? = null, override val email: String? = null,
    override val startTime: Date? = null, override val endTime: Date? = null
) : UserQuery {

    override fun withPageable(pageable: Pageable): PageQuery {
        return UserByPageQuery(this, pageable)
    }

}



/**
 * 用户查询基础上包含了一个分页参数 Query ....
 */
class UserByPageQuery(private val userQuery: UserQuery, private val pageable: Pageable) : UserQuery by userQuery,
    PageQuery {
    override fun getPageable(): Pageable = pageable

    override fun withPageable(pageable: Pageable): UserByPageQuery {
        return UserByPageQuery(this.userQuery, pageable)
    }
}