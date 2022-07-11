package club.smileboy.app.mlnlco.model.params.store.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 21:12
 * @description 用户保存参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserStoreParam implements UserStoreParam {
    /**
     * 昵称
     */
    @ApiModelProperty("nickName")
    @Length(max= 20,message="编码长度不能超过20")
    private String nickName;
    /**
     * 用户名
     */
    @NotBlank(message="[用户名]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("userName")
    @Length(max= 20,message="编码长度不能超过20")
    private String userName;

    /**
     * 邮箱名
     */
    @NotBlank(message="[邮箱]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("")
    @Length(max= 100,message="编码长度不能超过100")
    private String email;
    /**
     * 密码
     */
    @NotBlank(message="[密码]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("")
    @Length(max= 127,message="编码长度不能超过127")
    private String password;
    /**
     * 个人简介
     */
    @ApiModelProperty("个人简介")
    @Length(max= 255,message="编码长度不能超过255")
    private String description;

}
