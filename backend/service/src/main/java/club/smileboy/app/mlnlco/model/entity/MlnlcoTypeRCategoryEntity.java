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
* mlnlco 业务类型 - 分类表
* @TableName mlnlco_type_r_category
*/
@Data
@TableName("mlnlco_type_r_category")
@AllArgsConstructor
@NoArgsConstructor
public class MlnlcoTypeRCategoryEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type= IdType.AUTO)
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 数据 id
    */
    @NotNull(message="[数据 id]不能为空")
    @ApiModelProperty("数据 id")
    private Long dataId;
    /**
    * 歌单分类id
    */
    @NotNull(message="[歌单分类id]不能为空")
    @ApiModelProperty("歌单分类id")
    private Long categoryId;
    /**
    * 业务分类类型,歌曲 ,歌单 ,收藏,等等其他类型,源于数据字典
    */
    @NotBlank(message="[业务分类类型,歌曲 ,歌单 ,收藏,等等其他类型,源于数据字典]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("业务分类类型,歌曲 ,歌单 ,收藏,等等其他类型,源于数据字典")
    @Length(max= 50,message="编码长度不能超过50")
    private String businessCategoryType;
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
