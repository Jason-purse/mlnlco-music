package club.smileboy.app.mlnlco.service.inline

import org.junit.jupiter.api.Test

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 11:46
 * @description inline tests
 **/
class InlineTests {

    @Test
    fun inlineReturn() {
        "".let {
            return
        }
        println("你好")
    }
    @Test
    fun inlineNoReturn() {
        "".let {
            ""
        }
        println("123")
    }

    /**
     * 这种方式不安全
     */
    inline fun a( action: () -> Unit) {
        action()
    }
    @Test
    fun inlineFuncReturn() {
        a {
            return
        }
        println("123")
    }

    inline fun b(noinline action: () -> Unit) {
        action()
    }


    @Test
    fun inlineNoInlineActionFunctionReturn() {
        b {
            // 不允许return
            return@b
        }
        println("1231")
    }

}