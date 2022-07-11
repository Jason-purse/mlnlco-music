package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.params.store.sheet.DefaultSheetSaveParam
import club.smileboy.app.mlnlco.model.params.store.sheet.SheetStoreParam
import club.smileboy.app.mlnlco.model.vo.SheetVo

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 21:45
 * @description sheet service
 **/
interface SheetService {
    /**
     * 根据sheet 类型进行 sheet 简要 info 查询
     * @param sheetTypeId sheet type ref id
     */
    fun findAllSheetInfoByCategory(sheetTypeId: Long): List<SheetVo>

    /**
     * 保存一个Sheet info
     * @param sheetSaveParam 保存sheet 信息参数
     */
    fun insertSheetInfoByParams(sheetSaveParam: DefaultSheetSaveParam)

    /**
     * 根据sheetStoreParam更新一个Sheet info
     * @param sheetStoreParam 更新参数
     */
    fun updateSheetInfoByParams(id: Long,sheetStoreParam: SheetStoreParam): SheetVo

    /**
     * 根据sheet id 删除一个 sheet info
     * @param id sheet id
     */
    fun deleteSheetInfoById(id: Long)
}