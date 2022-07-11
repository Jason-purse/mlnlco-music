package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipDeleteParam
import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipSaveParam
import club.smileboy.app.mlnlco.service.OperationService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 18:26
 * @description 用户操作接口
 *
 * 1. 添加歌单
 *      默认歌单: 我喜欢 ...
 * 2. 添加收藏
 **/
@Api("用户操作列表")
@RestController
@RequestMapping("api/mlnlco/user/operation/v1")
class UserOperationController(val operationService: OperationService) {

    /**
     * 保存 media 和 sheet 之间的关系
     * music and sheet
     * video and sheet
     * etc ...
     */
    @PostMapping
    fun insertMediaAndSheetRelationShip(@RequestBody msRelationShipSaveParam: MSRelationShipSaveParam) {
        operationService.insertMediaAndSheetRelationShip(msRelationShipSaveParam)
    }

    /**
     * 删除media 和 sheet 之间的关系
     * music and sheet
     * video and sheet
     */
    @DeleteMapping
    fun deleteMediaAndSheetRelationShip(@RequestBody msRelationShipDeleteParam: MSRelationShipDeleteParam) {
        operationService.deleteMediaAndSheetRelationShip(msRelationShipDeleteParam)
    }



}