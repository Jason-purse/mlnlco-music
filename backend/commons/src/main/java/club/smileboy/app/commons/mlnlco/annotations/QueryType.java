package club.smileboy.app.commons.mlnlco.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:57
 * @description 查询类型,可以指定在方法上 / 接口上
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface QueryType {
    /**
     * 查询具体类型 / 默认值
     */
    Class<?> value();
}
