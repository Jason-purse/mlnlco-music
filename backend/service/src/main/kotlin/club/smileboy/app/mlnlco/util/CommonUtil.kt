package club.smileboy.app.mlnlco.util

/**
 * 更好的利用Evlis 操作符
 */
fun String?.isNotBlankForBool(): Boolean? {
    return this?.isNotBlank()?.let {
        if (it)
            it
        else
            null
    }
}