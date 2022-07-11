package club.smileboy.app.mlnlco.util

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable

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

/**
 * Any 是否为空,for boolean
 */
fun Any?.isNotNullForBool(): Boolean? {
    return this?.let { true }
}

/**
 * 判断集合是否为空 for boolean
 */
fun <T : Any> Collection<T>?.isNotEmptyForBool(): Boolean? {
    return this?.isNotEmpty().let { if(it == true) it else null }
}

/**
 * 将Pageable 转换为 page
 */
fun <T> Pageable.toPage(): Page<T> {
    return Page.of(pageNumber.toLong(),pageSize.toLong())
}