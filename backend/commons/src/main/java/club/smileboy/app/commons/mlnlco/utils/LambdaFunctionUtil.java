package club.smileboy.app.commons.mlnlco.utils;

import java.util.function.Supplier;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 13:37
 * @description lambda 函数表达式工具类
 **/
public class LambdaFunctionUtil {

    /**
     * 产生一个Supplier
     * @param defaultValue 默认值
     * @param <T> 类型
     * @return 返回一个Supplier
     */
    public static <T> Supplier<T> supplier(T defaultValue) {
        return () -> defaultValue;
    }
}
