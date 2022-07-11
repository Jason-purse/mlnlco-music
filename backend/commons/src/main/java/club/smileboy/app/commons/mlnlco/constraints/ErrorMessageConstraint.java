package club.smileboy.app.commons.mlnlco.constraints;

import club.smileboy.app.commons.mlnlco.exceptions.DataException;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 国际化消息约定 ....
 */
public enum ErrorMessageConstraint {
    /**
     * 用户信息不存在
     */
    USER_INFO_ZERO("user.info.0"),
    /**
     * 用户信息存在
     */
    USER_INFO_ONE("user.info.1"),
    /**
     * 通用信息不存在模板
     */
    GENERAL_INFO_ZERO("general_info.0",true) ,

    /**
     * 通用信息存在模板
     */
    GENERAL_INFO_ONE("general_info.1",true),

    /**
     * 通用信息存在模板 2
     */
    GENERAL_INFO_TWO("general_info.2",true),

    /**
     * 音乐名称信息
     */
    MUSIC_INFO_TITLE("music.info.name"),
    /**
     * 专辑
     */
    MUSIC_INFO_ALBUM("music.info.album"),
    /**
     * 歌手
     */
    MUSIC_INFO_SINGER("music.info.singer"),
    /**
     * 音乐(名词)
     */
    MUSIC("music"),
    /**
     * 冲突
     */
    CONFLICT("conflict"),
    /**
     * 数据不合法之 数据为空
     */
    DATA_VIOLATION_EMPTY("data.violation.empty"),

    /**
     * 数据不存在 ...
     */
    DATA_EMPTY("data.empty"),

    /**
     * 数据不合法之数据模板为空
     */
    DATA_VIOLATION_TEMPLATE_EMPTY("data.violation.template.empty",true),
    /**
     * 歌单
     */
    SHEET_PLAYLIST("sheet.playlist"),
    /**
     * 收藏(其实也叫歌单)
     */
    SHEET_COLLECTION("sheet.collection"),

    /**
     * 名称
     */
    TITLE("title"),
    /**
     * 字典
     */
    DICT("dict")
    ;
    private final static String BASE_NAME = "mlnlco_system_error_message";
    private final static Map<Locale, ResourceBundle> resourceBundleMapCache;
    private final static Map<Locale, Boolean> loadedCache;

    static {
        resourceBundleMapCache = new LinkedHashMap<>();
        loadedCache = new LinkedHashMap<>();
    }

    private final String messageCode;
    /**
     * 是否可以进行 模板拼接 ...
     * 是否可以消息格式化
     * {@link java.text.MessageFormat}
     */
    private final Boolean canEvaluate;

    ErrorMessageConstraint(String messageCode, Boolean canEvaluate) {
        this.messageCode = messageCode;
        this.canEvaluate = canEvaluate;
    }

    /**
     * 默认不会进行任何格式化
     * @param message  消息
     * @param params 参数
     * @return 格式化结果
     */
    public  String evaluateMessage(String message,Object ...params) {
       if(canEvaluate) {
           return new MessageFormat(message).format(params,new StringBuffer(),null).toString();
       }
        return message;
    }

    private ErrorMessageConstraint(String messageCode) {
        this(messageCode,false);
    }

    public Boolean getCanEvaluate() {
        return canEvaluate;
    }

    public String getMessageCode() {
        return messageCode;
    }

    /**
     * 根据Locale 进行国际化资源读取
     * 消息进行国际化区分
     *
     * @param locale  locale
     * @param keyCode 消息码
     * @return 国际化消息
     */
    public static String evaluateMessageOrNullByLocale(Locale locale, String keyCode) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ResourceBundle resourceBundle = resourceBundleMapCache.get(locale);
        if (resourceBundle == null) {
            // 所有约束变量应该走这个
            synchronized (ErrorMessageConstraint.class) {
                if (resourceBundleMapCache.get(locale) == null) {
                    if (!loadedCache.get(locale)) {
                        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
                        resourceBundleMapCache.put(locale, resourceBundle);
                        loadedCache.put(locale, Boolean.TRUE);
                    }
                }
            }
        }

        // 获取默认的 资源约束
        if (resourceBundle == null) {
            if (locale == Locale.getDefault()) {
                throw new DataException("system error,default resource bundle was not occur in this project ...");
            }

            // 否则 获取默认的 进行资源获取
            resourceBundle = resourceBundleMapCache.get(locale);
        }

        try {
            return resourceBundle.getString(keyCode);
        } catch (Exception e) {
            // pass
        }
        //根据 异常交给调用方
        return null;
    }
}