package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 19:54
 * @description 通用异常,未知种类 ...
 **/
public class GeneralException extends MlnlcoException {
    private final static String CODE = "2020";
    @Override
    String getTemplateTips(String message) {
        return String.format("GENERAL EXCEPTION [ %s ]", message);
    }

    @Override
    String getErrorCode() {
        return CODE;
    }

    public GeneralException(Throwable cause) {
        super(cause);
    }
}
