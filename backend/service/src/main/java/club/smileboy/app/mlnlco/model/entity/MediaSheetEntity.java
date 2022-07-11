package club.smileboy.app.mlnlco.model.entity;

import club.smileboy.app.mlnlco.model.CommonEntityField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
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
* 歌单表
* @TableName media_sheet
*/
@Data
@TableName("media_sheet")
@AllArgsConstructor
@NoArgsConstructor
public class MediaSheetEntity implements CommonEntityField, Serializable {

    /**
    * id
    */
    @TableId(type= IdType.AUTO)
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 表名
    */
    @NotBlank(message="[表名]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("表名")
    @Length(max= 127,message="编码长度不能超过127")
    private String sheetName;
    /**
    * 图片链接
    */
    @NotBlank(message="[图片链接]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("图片链接")
    @Length(max= 255,message="编码长度不能超过255")
    private String imageUrl;
    /**
    * 例如,歌单描述
    */
    @NotBlank(message="[例如,歌单描述]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("例如,歌单描述")
    @Length(max= 255,message="编码长度不能超过255")
    private String description;
    /**
    * 创建人ID
    */
    @NotNull(message="[创建人ID]不能为空")
    @ApiModelProperty("创建人ID")
    private Long userId;
    /**
    * 歌单类型,例如叫做歌单,视频集
    */
    @NotNull(message="[歌单类型,例如叫做歌单,视频集]不能为空")
    @ApiModelProperty("歌单类型,例如叫做歌单,视频集")
    private Long sheetTypeId;
    /**
    * version
    */
    @NotNull(message="[version]不能为空")
    @ApiModelProperty("乐观锁")
    @Version
    private Long version;
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
