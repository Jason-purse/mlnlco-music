package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.params.query.dict.DataDictQuery
import club.smileboy.app.mlnlco.model.params.query.dict.DataDictStoreParam
import club.smileboy.app.mlnlco.model.vo.DataDictVo
import club.smileboy.app.mlnlco.service.DataDictService
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * @author FLJ
 * @date 2022/7/11
 * @time 9:43
 * @Description 数据字典 Controller
 */
@RestController
@RequestMapping("api/mlnlco/dict/v1")
class DataDictController(private val dataDictService: DataDictService) {
    /**
     * 非懒加载形式
     * 获取所有的DataDict ...
     * 形式:
     * DataDict:
     *     - DataDictItem
     *     - DataDictItem
     *
     * sex:
     *  - 男
     *  - 女
     * resource type:
     *  - media
     *  - other
     *  - etc
     */
    @GetMapping("all")
    fun findAllDataDictItemsByQueryAndPage(dataDictQuery: DataDictQuery,pageable: Pageable): Page<DataDictVo> {
        return dataDictService.findAllDataDictItemsByQueryAndPage(dataDictQuery,pageable)
    }

    /**
     * 分页查询所有DataTypes
     * @param pageable 分页参数
     */
    @GetMapping("lazy/type/all")
    fun findAllDataDictTypesByPage(pageable: Pageable): Page<DataDictVo> {
        return dataDictService.findAllDataDictTypesByPage(pageable)
    }

    /**
     * 根据dataType 查询所有的DataItems
     * @param dataType 数据类型
     */
    @GetMapping("lazy/item/{type}")
    fun findAllDataItemsByDataType(@PathVariable("type") dataType: String): List<DataDictVo.DataDictItemVo> {
        return dataDictService.findAllDataItemsByDataType(dataType)
    }

    /**
     * 更新一个 data dict item / type
     */
    @PutMapping("{id}")
    fun updateDataTypeByParams(@PathVariable("id") id: Long,@RequestBody dataDictStoreParam: DataDictStoreParam) {
        return dataDictService.updateDataDictInfoByParams(id,dataDictStoreParam);
    }



}