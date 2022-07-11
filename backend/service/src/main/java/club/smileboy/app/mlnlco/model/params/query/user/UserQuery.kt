package club.smileboy.app.mlnlco.model.params.query.user

import club.smileboy.app.commons.mlnlco.annotations.QueryType
import club.smileboy.app.mlnlco.model.params.query.Query
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:55
 * @description 用户相关的Query 接口抽象
 **/
@QueryType(DefaultUserQuery::class)
interface UserQuery : Query {
     val nickName: String?
     val userName: String?
     val email: String?
     val createTime: Date?
     val startTime: Date?
     val endTime: Date?
}