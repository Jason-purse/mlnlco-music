package club.smileboy.app.commons.mlnlco.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 13:10
 * @description 猫王操作符,更好的结合kotlin 写出优雅的代码
 **/
public class ElvisUtil {

    /**
     * 断言是否为空
     * @param t 变量
     * @param supplier 提供默认值的provider
     * @param <T> 变量的类型
     * @return 非空变量
     */
    public static <T> T assertNotNullOrDefault(T t, Supplier<T> supplier) {
        if(Objects.isNull(t)) {
            return supplier.get();
        }
        return t;
    }

    /**
     * 断言是否为空,且进行action,否则提供一个action结果的默认类型值
     * @param t 变量
     * @param action 动作
     * @param supplier 默认值提供器
     * @param <T> 类型
     * @param <R> 目标类型
     * @return 目标对象 或者 默认值
     */
    public static <T,R> R assertNotNullAndActionOrDefault(T t, Function<T,R> action, Supplier<R> supplier) {
        if(Objects.isNull(t)) {
            supplier.get();
        }
        return action.apply(t);
    }

    /**
     * 断言是否为空,且进行action,否则提供一个action结果的默认类型值
     * @param t 变量
     * @param action 动作
     * @param supplier 默认值提供器
     * @param <T> 类型
     * @param <R> 目标类型
     * @return 目标对象或者抛出异常 ..
     */
    public static <T,R> R assertNotNullAndActionOrThrow(T t, Function<T,R> action, Supplier<RuntimeException> supplier) {
        if(Objects.isNull(t)) {
            throw supplier.get();
        }
        return action.apply(t);
    }

    /**
     * 断言是否为空,且进行action,否则提供一个action结果的默认类型值
     * @param t 变量
     * @param supplier 默认值提供器
     * @param <T> 类型
     * @return 对象或者抛出异常 ..
     */
    public static <T> T assertNotNullOrThrow(T t, Supplier<RuntimeException> supplier) {
        if(Objects.isNull(t)) {
            throw supplier.get();
        }
       return t;
    }

    /**
     * 断言列表是否为空 返回默认值,否则做action
     * @param t 列表
     * @param action 动作
     * @param listSupplier 默认值
     * @param <T> 原始Element 类型
     * @param <R> 目标Element 类型
     * @return 目标Element 元素列表
     */
    public static <T,R> List<R> assertListNotEmptyAndActionOrDefault(List<T> t,Function<List<T>,List<R>> action,Supplier<List<R>> listSupplier) {
        if(!CollectionUtils.isEmpty(t)) {
            return action.apply(t);
        }
        return listSupplier.get();
    }
}
