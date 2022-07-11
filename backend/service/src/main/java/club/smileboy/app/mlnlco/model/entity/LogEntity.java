package club.smileboy.app.mlnlco.model.entity;

import club.smileboy.app.mlnlco.model.CommonEntityField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
* 日志表
* @TableName log
*/
@AllArgsConstructor
@NoArgsConstructor
@TableName("log")
@Data
public class LogEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 标题
    */
    @NotBlank(message="[标题]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("标题")
    @Length(max= 127,message="编码长度不能超过127")
    private String title;
    /**
    * 内容
    */
    @NotBlank(message="[内容]不能为空")
    @Size(max= 512,message="编码长度不能超过512")
    @ApiModelProperty("内容")
    @Length(max= 512,message="编码长度不能超过512")
    private String description;
    /**
    * 操作人邮箱
    */
    @NotBlank(message="[操作人邮箱]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("操作人邮箱")
    @Length(max= 127,message="编码长度不能超过127")
    private String operatorEmail;
    /**
    * 操作人姓名
    */
    @NotBlank(message="[操作人姓名]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("操作人姓名")
    @Length(max= 20,message="编码长度不能超过20")
    private String operatorName;
    /**
    * 日志分类
    */
    @NotNull(message="[日志分类]不能为空")
    @ApiModelProperty("日志分类")
    private Object categoryId;
    /**
    * 操作人ip地址
    */
    @NotBlank(message="[操作人ip地址]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("操作人ip地址")
    @Length(max= 127,message="编码长度不能超过127")
    private String ipAddress;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer version;
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
    @TableField("create_time_str")
    private String createTimeStr;

    /**
     *
     */
    @TableField("update_time_str")
    private String updateTimeStr;

    private static final long serialVersionUID = 1L;
}
