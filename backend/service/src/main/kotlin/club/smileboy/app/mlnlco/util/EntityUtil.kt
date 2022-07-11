package club.smileboy.app.mlnlco.util

import club.smileboy.app.commons.mlnlco.utils.DateUtil
import club.smileboy.app.mlnlco.model.CommonEntityField
import java.util.*
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 12:57
 * @description 系统 保存Entity 的默认值
 **/
fun CommonEntityField.defaultValue() {
    createTime  = Date()
    updateTime = createTime
    createTimeStr = DateUtil.getLocaleDateString(createTime)
    updateTimeStr = createTimeStr
}