package club.smileboy.app.commons.mlnlco.exceptions;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 18:18
 * @description 数据异常 ...
 **/
public class DataException extends MlnlcoException{
    public final static String CODE = "2010";

    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

    @Override
    String getTemplateTips(String message) {
        return String.format("DATA EXCEPTION: [ %s ]", message);
    }

    @Override
    String getErrorCode() {
        return CODE;
    }
}
