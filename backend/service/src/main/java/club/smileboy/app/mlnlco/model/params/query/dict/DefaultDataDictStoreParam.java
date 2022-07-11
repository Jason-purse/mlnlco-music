package club.smileboy.app.mlnlco.model.params.query.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FLJ
 * @date 2022/7/11
 * @time 11:50
 * @Description 默认的数据Dict 存储参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultDataDictStoreParam implements DataDictStoreParam {

    /**
     * 数据字典存储类型, type / item
     */
    private String dataDictStoreType;

    /**
     * 名称
     */
    private String title;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据item code
     */
    private String dataItem;

}
