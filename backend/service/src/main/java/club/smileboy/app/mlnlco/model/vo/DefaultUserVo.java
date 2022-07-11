package club.smileboy.app.mlnlco.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 23:38
 * @description 用户Vo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultUserVo implements UserVo {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;
    /**
     * 别名
     */
    @ApiModelProperty("nickName")
    private String nickName;
    /**
     * 用户名称 唯一
     */
    @ApiModelProperty("userName")
    private String userName;
    /**
     * 邮箱
     */
    @ApiModelProperty("email")
    private String email;

    /**
     * 描述
     */
    @ApiModelProperty("description")
    private String description;

    /**
     * 用户类型 文本表示,取决于数据字典
     */
    @ApiModelProperty("用户类型,取决于数据字典")
    private String userType;

    /**
     * 是否删除 0 / 1 (0表示未删除)
     */
    @ApiModelProperty("是否删除")
    private Boolean deleted;
    /**
     * 更新时间
     */
    @ApiModelProperty("updateTime")
    private Date updateTime;
    /**
     * 更新时间文本形式, 根据请求的Locale 进行设定 ...
     */
    @ApiModelProperty("updateTimeStr")
    private String updateTimeStr;
    /**
     * 创建时间
     */
    @ApiModelProperty("createTime")
    private Date createTime;
    /**
     * 创建时间文本形式, 根据请求的Locale 进行设定 ...
     */
    @ApiModelProperty("createTimeStr")
    private String createTimeStr;
}
