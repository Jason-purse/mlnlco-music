package club.smileboy.app.mlnlco.model.entity;

import club.smileboy.app.mlnlco.model.CommonEntityField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 菜单表
* @TableName menu
*/
@Data
@TableName("menu")
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type= IdType.AUTO)
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 父节点ID
    */
    @NotNull(message="[父节点ID]不能为空")
    @ApiModelProperty("父节点ID")
    private Long parentId;
    /**
    * 标题
    */
    @NotBlank(message="[标题]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("标题")
    @Length(max= 20,message="编码长度不能超过20")
    private String title;
    /**
    * 权限代码
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("权限代码")
    @Length(max= 100,message="编码长度不能超过100")
    private String permission;
    /**
    * 权限类型,菜单 / 按钮
    */
    @NotBlank(message="[权限类型,菜单 / 按钮]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("权限类型,菜单 / 按钮")
    @Length(max= 100,message="编码长度不能超过100")
    private String permissiontypeid;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Object version;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Boolean deleted;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Date createTime;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Date updateTime;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("")
    @Length(max= 100,message="编码长度不能超过100")
    private String createTimeStr;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("")
    @Length(max= 100,message="编码长度不能超过100")
    private String updateTimeStr;
}
