package club.smileboy.app.mlnlco.model.params.trans.login;

import lombok.Data;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 22:13
 * @description 默认的登录参数
 **/
@Data
public class DefaultLoginParam implements LoginParam {
    /**
     * 用户类型(枚举Code,非数据Item Code)
     */
    private String userType;

    @Override
    public String getUserType() {
        return userType;
    }
}
