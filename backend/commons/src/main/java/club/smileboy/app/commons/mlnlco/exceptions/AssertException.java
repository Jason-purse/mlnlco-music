package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 12:35
 * @description 仅作断言异常 ...(系统开发阶段的提示错误,生产环境不会出现这个异常)
 **/
public class AssertException extends MlnlcoException {

    public final static String CODE = "2030";

    public AssertException() {
        super();
    }

    public AssertException(String message) {
        super(message);
    }

    public AssertException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    String getTemplateTips(String message) {
        return String.format("ASSERT EXCEPTION [ %s ]", message);
    }

    @Override
    String getErrorCode() {
        return CODE;
    }
}
