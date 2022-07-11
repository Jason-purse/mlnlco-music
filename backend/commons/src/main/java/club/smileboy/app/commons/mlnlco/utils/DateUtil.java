package club.smileboy.app.commons.mlnlco.utils;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 21:54
 * @description 日期工具类
 **/
public class DateUtil {

    /**
     * 日期格式化处理
     * @param date date-time
     * @param locale locale
     * @return 格式化时间字符串
     */
    public static String getLocaleDateString(@NotNull Date date, @NotNull Locale locale) {
        return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale).format(date);
    }

    /**
     * 系统locale 日期格式化处理
     * @param date date-time
     * @return 格式化时间字符串
     */
    public static String getLocaleDateString(@NotNull Date date) {
        return getLocaleDateString(date,Locale.getDefault());
    }
}
