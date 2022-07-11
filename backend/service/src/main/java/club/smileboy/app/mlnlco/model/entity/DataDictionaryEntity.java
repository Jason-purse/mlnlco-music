package club.smileboy.app.mlnlco.model.entity;

import club.smileboy.app.mlnlco.model.CommonEntityField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典
 * @TableName data_dictionary
 */
@Data
@TableName("data_dictionary")
@AllArgsConstructor
@NoArgsConstructor
public class DataDictionaryEntity implements CommonEntityField,Serializable {
    /**
     *  id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String title;

    /**
     * 数据类型
     */
    @TableField("data_type")
    private String dataType;

    /**
     * 数据项
     */
    @TableField("data_item")
    private String dataItem;

    /**
     * version
     */
    @Version
    private Long version;

    /**
     * 
     */
    private Boolean deleted;

    /**
     * 
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField("update_time")
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