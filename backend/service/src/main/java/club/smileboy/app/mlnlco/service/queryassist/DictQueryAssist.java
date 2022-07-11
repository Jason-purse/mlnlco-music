package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.mlnlco.model.entity.DataDictionaryEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictQueryAssist {

    /**
     * 根据数据类型和数据项代码 构建一个查询条件
     * @param dataType 数据类型
     * @param dataItemCode 数据项代码
     * @return 针对于词典的查询条件
     */
    @Nullable
    public static Wrapper<DataDictionaryEntity> createDataTypeAndItemCodeQuery(@NotNull String dataType, @NotNull String dataItemCode) {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).eq(DataDictionaryEntity::getDataType,dataType)
                .eq(DataDictionaryEntity::getDataItem,dataItemCode);

    }

    /**
     * 根据数据类型构造一个查询条件
     * @param dataType 数据类型
     * @return 数据类型 eq 查询条件Query
     */
    @Nullable
    public static Wrapper<DataDictionaryEntity> createDataTypeQuery(@NotNull String dataType) {
        return new LambdaQueryWrapper<>(DataDictionaryEntity.class).eq(DataDictionaryEntity::getDataType,dataType);
    }
}
