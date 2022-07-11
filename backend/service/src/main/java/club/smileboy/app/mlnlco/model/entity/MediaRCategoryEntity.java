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
* 媒体 - 关系 -分类表
* @TableName media_r_category
*/
@Data
@TableName("media_r_category")
@AllArgsConstructor
@NoArgsConstructor
public class MediaRCategoryEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 分类id
    */
    @NotNull(message="[分类id]不能为空")
    @ApiModelProperty("分类id")
    private Long tagId;
    /**
    * 数据id,例如 歌曲id, 歌单id, 收集id
    */
    @NotNull(message="[数据id,例如 歌曲id, 歌单id, 收集id]不能为空")
    @ApiModelProperty("数据id,例如 歌曲id, 歌单id, 收集id")
    private Long dataId;
    /**
    *  乐观锁
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Object version;
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
