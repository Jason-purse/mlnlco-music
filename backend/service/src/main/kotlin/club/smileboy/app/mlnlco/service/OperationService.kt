package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipDeleteParam
import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipSaveParam

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 18:29
 * @description 用户的操作
 **/
interface OperationService {

    /**
     * 新增一个Media 和 Sheet 之间的关系
     * @param msRelationShipSaveParam 新增关系参数
     */
    fun insertMediaAndSheetRelationShip(msRelationShipSaveParam: MSRelationShipSaveParam)


    /**
     * 删除一个Media 和 Sheet 之间的关系
     * @param msRelationShipDeleteParam 删除关系参数
     */
    fun deleteMediaAndSheetRelationShip(msRelationShipDeleteParam: MSRelationShipDeleteParam)

    /**
     * 删除媒体和sheet 之间的关系 ...
     * 例如 删除一个Sheet
     * @param sheetId sheetId
     */
    fun deleteMediaAndSheetRelationShipById(sheetId: Long)
}