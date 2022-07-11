package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 13:07
 * @description Bean Util 异常
 **/
public class BeanUtilsException extends MlnlcoException {
    public final static String CODE = "2000";

    public BeanUtilsException() {
        super();
    }


    public BeanUtilsException(String message) {
        super(message);
    }

    public BeanUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanUtilsException(Throwable cause) {
        super(cause);
    }

    @Override
    String getTemplateTips(String message) {
        return String.format("BeanUtils Exception [ %s ]", message);
    }

    @Override
    String getErrorCode() {
        return CODE;
    }
}
