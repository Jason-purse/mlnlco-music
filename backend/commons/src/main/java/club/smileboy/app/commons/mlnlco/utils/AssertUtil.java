package club.smileboy.app.commons.mlnlco.utils;

import club.smileboy.app.commons.mlnlco.exceptions.MlnlcoException;

import java.util.function.Supplier;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 11:20
 * @description 断言工具类
 **/
public class AssertUtil {
    /**
     * 断言 是否为真
     * @param result 结果
     * @param supplier 异常提供器
     */
    public static void assertLogicTrue(Boolean result, Supplier<MlnlcoException> supplier) {
        if(!result) {
            throw supplier.get();
        }
    }

}
