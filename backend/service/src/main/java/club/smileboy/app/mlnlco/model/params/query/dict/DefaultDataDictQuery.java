package club.smileboy.app.mlnlco.model.params.query.dict;

import club.smileboy.app.mlnlco.model.params.query.PageQuery;
import club.smileboy.app.mlnlco.model.params.query.Query;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Pageable;
/**
 * @author FLJ
 * @date 2022/7/11
 * @time 9:51
 * @Description 默认的数据字典查询对象
 */
@Data
public class DefaultDataDictQuery implements DataDictQuery, Query  {

    /**
     * 根据数据类型进行查询
     * 非 数据字典根节点
     * @see club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType#SYSTEM_TYPE
     */
    @Nullable
    private String dataType;


    @NotNull
    @Override
    public PageQuery withPageable(@NotNull Pageable pageable) {
        throw new NullPointerException("with pageable can't use");
    }
}
