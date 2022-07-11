package club.smileboy.app.mlnlco.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author FLJ
 * @date 2022/7/11
 * @time 9:44
 * @Description 数据字典Vo
 */
public interface DataDictVo {

    /**
     * 字典类型Id
     * @return
     */
    Long getId();

    /**
     * 数据类型(code)
     */
    String getDataType();

    /**
     * 名称
     */
    String getName();

    /**
     * 获取所有的Dict Item
     */
    List<DataDictItemVo> getChildren();


    /**
     * 数据字典Item 接口抽象
     */
    interface  DataDictItemVo {
        /**
         * 数据类型 code
         */
        String getDataType();
        String getItemName();
        String getItemCode();
        Long getId();

        static DataDictItemVo of(Long id,String dataType,String itemName,String itemCode) {
            return new DefaultDictDataItemVo(dataType,itemCode,id,itemName);
        }
    }

    static DataDictVo of(Long id,String dataType,String name,List<DataDictItemVo> children) {
        return new DefaultDictVo(id,dataType,name,children);
    }
}

@AllArgsConstructor
class DefaultDictVo implements DataDictVo {

    @Getter
    private Long id;
    @Getter
    private String dataType;
    @Getter
    private String name;

    @Getter
    private List<DataDictItemVo> children;
}

@AllArgsConstructor
class DefaultDictDataItemVo implements DataDictVo.DataDictItemVo {

    @Getter
    private String dataType;
    @Getter
    private String itemCode;
    @Getter
    private Long Id;
    @Getter
    private String itemName;

}
