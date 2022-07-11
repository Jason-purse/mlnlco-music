package club.smileboy.app.mlnlco.service.nullable

import org.junit.jupiter.api.Test

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 13:30
 * @description 可空性测试
 **/
class NullableTests {

    @Test
    fun nullableTests() {
        val a:String? = null
        println(a?.isBlank())
    }
}