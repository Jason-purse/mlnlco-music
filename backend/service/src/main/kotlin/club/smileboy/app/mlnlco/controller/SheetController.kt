package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.params.store.sheet.DefaultSheetSaveParam
import club.smileboy.app.mlnlco.model.params.store.sheet.DefaultSheetUpdateParam
import club.smileboy.app.mlnlco.model.params.store.sheet.SheetStoreParam
import club.smileboy.app.mlnlco.model.vo.SheetVo
import club.smileboy.app.mlnlco.service.SheetService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:43
 * @description sheet 接口列表
 **/
@Api("sheet 接口列表")
@RestController
@RequestMapping("api/mlnlco/sheet/v1")
class SheetController(private val sheetService: SheetService) {
    /**
     * 根据sheet 类型Sheet 简介查询
     * @param sheetTypeId sheet type ref id
     */
    @GetMapping("list")
    fun findAllSheetInfoByCategory(sheetTypeId: Long): List<SheetVo> =
        sheetService.findAllSheetInfoByCategory(sheetTypeId)

    /**
     * 保存一个Sheet
     * @param sheetSaveParam 保存 sheet 的info 参数
     */
    @PostMapping
    fun insertSheetInfoByParams(@RequestBody sheetSaveParam: DefaultSheetSaveParam) {
        sheetService.insertSheetInfoByParams(sheetSaveParam)
    }

    /**
     * 根据id 更新一个Sheet info
     * @param id sheet id
     * @param sheetStoreParam sheet 保存参数
     */
    @PutMapping("{id}")
    fun updateSheetInfoByParams(@PathVariable("id") id: Long,@RequestBody sheetStoreParam: DefaultSheetUpdateParam): SheetVo {
        return sheetService.updateSheetInfoByParams(id,sheetStoreParam)
    }

    /**
     * 根据Id 删除一个sheet info
     * @param id sheet id
     */
    @DeleteMapping("{id}")
    fun deleteSheetInfoById(@PathVariable("id") id: Long) {
        sheetService.deleteSheetInfoById(id)
    }

}