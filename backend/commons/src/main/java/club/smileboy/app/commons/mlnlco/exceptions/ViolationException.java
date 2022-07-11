package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author FLJ
 * @date 2022/7/11
 * @time 12:26
 * @Description 违反约束异常
 */
public class ViolationException extends MlnlcoException {

    public final static String CODE = "2040";

    @Override
    String getTemplateTips(String message) {
        return message;
    }

    @Override
    String getErrorCode() {
        return CODE;
    }
}
