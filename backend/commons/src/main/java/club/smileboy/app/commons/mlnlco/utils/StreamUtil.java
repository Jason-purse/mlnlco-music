package club.smileboy.app.commons.mlnlco.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtil {

    /**
     * 简化 list.stream,直接编写action 动作
     * @param action 动作
     * @param <T> 原始元素类型
     * @param <R> 目标类型
     * @return 目标类型列表
     */
    public static <T,R> Function<List<T>,List<R>> doAction(Function<T, R> action) {
        return list -> list.stream().map(action).collect(Collectors.toList());
    }

    /**
     * 简化 list.stream.map 和 ele -> transform .....
     * 同时执行两个动作
     * @param targetType 目标元素类型
     * @param <T> 原始元素类型
     * @param <R> 目标元素类型
     * @return 目标类型列表
     */
    public static <T,R> Function<List<T>,List<R>> doElementTypeMapAction(Class<R> targetType) {
        return doAction(BeanUtils.doElementTypeMap(targetType));
    }

    /**
     * 同上
     * @param consumer 用于最终元素对象实例的额外动作
     */
    public static <T,R> Function<List<T>,List<R>> doElementTypeMapAction(Class<R> targetType, Consumer<R> consumer) {
        return doAction(BeanUtils.doElementTypeMap(targetType,consumer));
    }

}
