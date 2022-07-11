package club.smileboy.app.mlnlco.model.auth;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 22:17
 * @description Auth User Info 屏蔽底层认证框架 细节
 **/
public interface AuthUserInfo {

    String getUserName();

    String getNickName();

    Long getId();


    String getEmail();


    String getDescription();


    String getUserType();


    String getBirthDay();

    /**
     * 通过 此工厂方法可以new 一个AuthUserInfo 实现
     * @return authUserInfo 实例(但是是未初始化的)
     */
    static AuthUserInfo unInitializeAuthUserInfo() {
        return new DefaultAuthUserInfo();
    }
}

/**
 * 默认实现
 */
@Data
class DefaultAuthUserInfo implements AuthUserInfo {
    public DefaultAuthUserInfo(@Nullable AuthUserInfo delegate) {
        this.delegate = delegate;
    }
    public DefaultAuthUserInfo() {
        this(null);
    }

    @Nullable
    private AuthUserInfo delegate;

    private String userName;

    private String nickName;

    private Long id;

    private String email;

    private String description;

    private String userType;

    private String birthday;

    @Override
    public String getUserName() {
        return delegate != null ? delegate.getUserName() : userName;
    }

    @Override
    public String getNickName() {
        return delegate != null ? delegate.getNickName() : nickName;
    }

    @Override
    public Long getId() {
        return delegate != null ? delegate.getId(): id;
    }

    @Override
    public String getEmail() {
        return delegate != null ? delegate.getEmail(): email;
    }

    @Override
    public String getDescription() {
        return delegate != null ? delegate.getDescription() : description;
    }

    @Override
    public String getUserType() {
        return delegate != null ? delegate.getUserType() : userType;
    }

    @Override
    public String getBirthDay() {
        return delegate != null ? delegate.getBirthDay() : birthday;
    }
}

