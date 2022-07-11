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
* 公告
* @TableName notice
*/
@Data
@TableName("notice")
@AllArgsConstructor
@NoArgsConstructor
public class NoticeEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type= IdType.AUTO)
    @NotNull(message="[id]不能为空")
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
    * 操作人
    */
    @NotBlank(message="[操作人]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("操作人")
    @Length(max= 20,message="编码长度不能超过20")
    private String operatorName;
    /**
    * 通知类型,来源于 数据字典
    */
    @NotNull(message="[通知类型,来源于 数据字典]不能为空")
    @ApiModelProperty("通知类型,来源于 数据字典")
    private Long noticeTypeId;
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
    private Date updateTime;
    /**
     *  更新时间str, 以系统的本地格式进行格式化 ...
     *  webUI 通过国际化展示 ..
     */
    @NotBlank(message="[]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("")
    @Length(max= 100,message="编码长度不能超过100")
    private String updateTimeStr;
    /**
     *
     */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Date createTime;
    /**
     *
     */
    @NotBlank(message="[]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("")
    @Length(max= 100,message="编码长度不能超过100")
    private String createTimeStr;

}
