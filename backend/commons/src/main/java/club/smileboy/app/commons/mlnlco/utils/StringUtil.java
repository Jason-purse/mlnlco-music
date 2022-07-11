package club.smileboy.app.commons.mlnlco.utils;

import org.springframework.util.StringUtils;

/**
 * 包含了字符串的一些工具方法,以及断言方法
 */
public class StringUtil {

    /**
     * 所有都不会 是 Blank
     * @param args string args
     * @return logic true /false
     * @apiNote args length is zero,result false
     *          otherwise, args all is not blank ,result will true ...
     */
    public static Boolean allIsNotBlank(String ... args) {
        if(args.length <= 0) {
            return Boolean.FALSE;
        }
        for (String arg : args) {
            if(!StringUtils.hasText(arg)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
