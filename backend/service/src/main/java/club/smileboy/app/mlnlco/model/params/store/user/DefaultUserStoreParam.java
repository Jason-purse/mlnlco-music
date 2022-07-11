package club.smileboy.app.mlnlco.model.params.store.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 18:41
 * @description 默认的用户存储参数实例
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultUserStoreParam implements UserStoreParam {
    /**
     * 用户描述
     */
    private String description;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;


    /**
     * 出生日期
     */
    private String birthday;

}