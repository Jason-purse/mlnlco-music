package club.smileboy.app.mlnlco.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:47
 * @description 默认的 sheet vo
 **/
@Data
public class DefaultSheetVo  implements SheetVo {

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;
    /**
     * 表名
     */
    @ApiModelProperty("表名")
    private String sheetName;
    /**
     * 图片链接
     */
    @ApiModelProperty("图片链接")
    private String imageUrl;
    /**
     * 例如,歌单描述
     */
    @ApiModelProperty("例如,歌单描述")
    private String description;
    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private Long userId;
    /**
     * 歌单类型,例如叫做歌单,视频集
     */
    @ApiModelProperty("歌单类型,例如叫做歌单,视频集")
    private Long sheetTypeId;


    /**
     * createTime
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * updateTime
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建时间戳
     */
    @ApiModelProperty("创建时间戳")
    private String createTimeStr;
    /**
     * 更新时间戳
     */
    @ApiModelProperty("更新时间戳")
    private String updateTimeStr;

}
