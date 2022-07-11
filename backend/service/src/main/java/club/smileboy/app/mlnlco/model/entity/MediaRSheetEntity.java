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
* 音乐-歌单-关系表
* @TableName media_r_sheet
*/
@Data
@TableName("media_r_sheet")
@AllArgsConstructor
@NoArgsConstructor
public class MediaRSheetEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 歌单ID
    */
    @NotNull(message="[歌单ID]不能为空")
    @ApiModelProperty("歌单ID")
    private Long sheetId;
    /**
    * 音乐ID
    */
    @NotNull(message="[音乐ID]不能为空")
    @ApiModelProperty("音乐ID")
    private Long mediaId;
    /**
    * 媒体类型,源于数据字典
    */
    @NotNull(message="[媒体类型,源于数据字典]不能为空")
    @ApiModelProperty("媒体类型,源于数据字典")
    private Long mediaTypeId;

    /**
     * sheet type id
     */
    private Long sheetTypeId;
    /**
    * deleted
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Boolean deleted;
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
