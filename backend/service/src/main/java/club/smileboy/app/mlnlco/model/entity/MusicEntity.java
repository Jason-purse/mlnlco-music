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
* 音乐表
* @TableName music
*/
@Data
@TableName("music")
@AllArgsConstructor
@NoArgsConstructor
public class MusicEntity implements CommonEntityField,Serializable {

    /**
    * id
    */
    @TableId(type= IdType.AUTO)
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("")
    @Length(max= 127,message="编码长度不能超过127")
    private String name;
    /**
    * 歌手
    */
    @NotBlank(message="[歌手]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("歌手")
    @Length(max= 127,message="编码长度不能超过127")
    private String singer;
    /**
    * 专辑
    */
    @NotBlank(message="[专辑]不能为空")
    @Size(max= 127,message="编码长度不能超过127")
    @ApiModelProperty("专辑")
    @Length(max= 127,message="编码长度不能超过127")
    private String album;
    /**
    * 歌曲简介
    */
    @NotBlank(message="[歌曲简介]不能为空")
    @Size(max= 2048,message="编码长度不能超过2048")
    @ApiModelProperty("歌曲简介")
    @Length(max= 2048,message="编码长度不能超过2,048")
    private String description;
    /**
    * 歌曲图片
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("歌曲图片")
    @Length(max= 255,message="编码长度不能超过255")
    private String imageUrl;
    /**
    * 歌曲时长
    */
    @NotNull(message="[歌曲时长]不能为空")
    @ApiModelProperty("歌曲时长")
    private Object duration;
    /**
    * 歌曲链接
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("歌曲链接")
    @Length(max= 255,message="编码长度不能超过255")
    private String url;
    /**
    * 歌词id
    */
    @ApiModelProperty("歌词id")
    private Object lyricsId;
    /**
    * 歌曲类型,例如 AAC,mp3,hls
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("歌曲类型,例如 AAC,mp3,hls")
    @Length(max= 50,message="编码长度不能超过50")
    private String mediaType;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Object version;

//    @NotNull(message="[]不能为空")
//    @ApiModelProperty("")
//    private Boolean deleted;


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
