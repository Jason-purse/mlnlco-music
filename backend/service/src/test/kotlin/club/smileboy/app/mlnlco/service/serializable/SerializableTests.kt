package club.smileboy.app.mlnlco.service.lambda.serializable

import club.smileboy.app.mlnlco.model.entity.UserEntity
import com.baomidou.mybatisplus.core.toolkit.support.SFunction
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda
import org.junit.jupiter.api.Test

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 11:37
 * @description 序列化测试
 **/
class SerializableTests {
    @Test
    fun test() {

        // error
//        println(SerializedLambda.extract(SFunction<Any,Any> { UserEntity::getCreateTime }).implMethodName)
    }
}