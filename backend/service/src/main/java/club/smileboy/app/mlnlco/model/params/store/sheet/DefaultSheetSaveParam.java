package club.smileboy.app.mlnlco.model.params.store.sheet;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 22:10
 * @description 默认的Sheet Store参数
 **/
@Data
public class DefaultSheetSaveParam implements SheetStoreParam {


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
    @Size(max= 2048,message="编码长度不能超过255")
    @ApiModelProperty("图片链接")
    @Length(max= 2048,message="编码长度不能超过255")
    private String imageUrl;
    /**
     * 例如,歌单描述
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("例如,歌单描述")
    @Length(max= 255,message="编码长度不能超过255")
    private String description;

    /**
     * 歌单类型,例如叫做歌单,视频集
     */
    @NotNull(message="[歌单类型,例如叫做歌单,视频集]不能为空")
    @ApiModelProperty("歌单类型,例如叫做歌单,视频集")
    private Long sheetTypeId;

    /**
     * 歌单类型(enum)
     * @see club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem#SHEET_TYPE_PLAYLIST ....
     */
    private String sheetType;

}
