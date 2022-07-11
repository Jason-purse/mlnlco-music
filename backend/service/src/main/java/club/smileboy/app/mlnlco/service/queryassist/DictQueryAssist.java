package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataType;
import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DictQueryAssist {

    /**
     * 根据数据类型和数据项代码 构建一个查询条件
     * @param dataType 数据类型
     * @param dataItemCode 数据项代码
     * @return 针对于词典的查询条件
     */
    public static Wrapper<DataDictionaryEntity> createDataTypeAndItemCodeQuery(@NotNull String dataType, @NotNull String dataItemCode) {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).eq(DataDictionaryEntity::getDataType,dataType)
                .eq(DataDictionaryEntity::getDataItem,dataItemCode);

    }

    /**
     * 根据数据类型构造一个查询条件
     * @param dataType 数据类型
     * @return 数据类型 eq 查询条件Query
     */
    public static Wrapper<DataDictionaryEntity> createDataTypeQuery(@NotNull List<String> dataType) {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).in(DataDictionaryEntity::getDataType,dataType);
    }

    /**
     * 当前系统所有的数据类型Query
     * @return 针对于所有数据类型的DataType的查询
     */
    public static Wrapper<DataDictionaryEntity> createSystemTypeQuery() {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).eq(DataDictionaryEntity::getDataType, GenericDataDictDataType.SYSTEM_TYPE);
    }

    /**
     * 查询一个查询data_type = .... 或者 data_type=system_type 且dataItem=data_type的所有数据
     * @param dataType 普通data_type
     * @param dataItem data_type = system_type dataItem=data_type
     * @return Query 实例
     */
    public static Wrapper<DataDictionaryEntity> createDataTypeAndSystemDataItemQuery(@NotNull String dataType, @NotNull String dataItem) {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).eq(DataDictionaryEntity::getDataType,dataType).or()
                .eq(DataDictionaryEntity::getDataType,GenericDataDictDataType.SYSTEM_TYPE).eq(DataDictionaryEntity::getDataItem,dataItem);
    }
}
