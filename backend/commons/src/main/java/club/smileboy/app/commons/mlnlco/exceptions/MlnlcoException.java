package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 18:17
 * @description Mlnlco系统的 顶级异常抽象
 **/
public abstract class MlnlcoException extends RuntimeException {

    public MlnlcoException() {
        super();
    }

    public MlnlcoException(String message) {
        super(message);
    }

    public MlnlcoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MlnlcoException(Throwable cause) {
        super(cause);
    }

    abstract String getTemplateTips(String message);


    @Override
    public String toString() {
        return getTemplateTips(getMessage());
    }

    abstract String getErrorCode();
}
