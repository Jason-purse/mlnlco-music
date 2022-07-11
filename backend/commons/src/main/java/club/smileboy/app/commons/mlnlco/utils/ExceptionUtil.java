package club.smileboy.app.commons.mlnlco.utils;

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint;
import club.smileboy.app.commons.mlnlco.exceptions.BeanUtilsException;
import club.smileboy.app.commons.mlnlco.exceptions.DataException;
import club.smileboy.app.commons.mlnlco.exceptions.GeneralException;
import club.smileboy.app.commons.mlnlco.exceptions.MlnlcoException;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 18:29
 * @description 异常工具类
 **/
public class ExceptionUtil {


    /**
     * 国际化异常消息,基于异常类型代码,消息错误代码生成异常 ...
     * @param code 异常类型代码
     * @param errorMessageConstraint 消息类型代码以及其他信息
     * @param locale locale 可空
     * @return 异常实例
     */
    public static MlnlcoException exception(String code,ErrorMessageConstraint errorMessageConstraint, @Nullable Locale locale) {
        return exception(code,errorMessageConstraint,locale);
    }

    /**
     * {@inheritDoc}
     */
    public static MlnlcoException exception(String code,ErrorMessageConstraint errorMessageConstraint) {
        return exception(code,errorMessageConstraint,null);
    }

    /**
     * 国际化异常消息,基于异常类型代码,消息错误代码生成异常 ...
     * @param code 异常类型代码
     * @param errorMessageConstraint 消息类型代码以及其他信息
     * @param locale locale 可空
     * @param params 格式化参数
     * @return 异常实例
     */
    public static MlnlcoException exception(String code,ErrorMessageConstraint errorMessageConstraint,@Nullable  Locale locale, Object  ...params) {
        Class<? extends MlnlcoException> exceptionType = ErrorMessageToExceptionMapRef.exceptionTypeMap.get(code);
        ElvisUtil.assertNotNullOrThrow(exceptionType, () -> new DataException(String.format("can't found the class type of the code [ %s ] !!!", code)));
        String message = ErrorMessageConstraint.evaluateMessageOrNullByLocale(locale, errorMessageConstraint.getMessageCode());
        // 获取消息
        ElvisUtil.assertNotNullOrThrow(message, () -> new DataException(String.format("can't found the error constraint of the code [ %s ] !!!", code)));
        assert message != null;
        if(errorMessageConstraint.getCanEvaluate()) {
            message = MessageFormat.format(message,params);
        }
        try {
            Constructor<? extends MlnlcoException> declaredConstructor = exceptionType.getDeclaredConstructor(String.class);
            return  BeanUtils.instantiateClass(declaredConstructor, message);
        } catch (Exception e) {
            // pass
            throw new GeneralException(e);
        }
    }
}

/**
 * 内部的异常映射
 */
class ErrorMessageToExceptionMapRef {
    public final static Map<String, Class<? extends MlnlcoException>> exceptionTypeMap;

    static {
        exceptionTypeMap = new LinkedHashMap<>();
        exceptionTypeMap.put(BeanUtilsException.CODE, BeanUtilsException.class);
        exceptionTypeMap.put(DataException.CODE, DataException.class);
    }
}


