package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint
import club.smileboy.app.commons.mlnlco.exceptions.DataException
import club.smileboy.app.commons.mlnlco.utils.BeanUtils
import club.smileboy.app.commons.mlnlco.utils.ExceptionUtil
import club.smileboy.app.commons.mlnlco.utils.RequestUtil
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.entity.MediaRSheetEntity
import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipDeleteParam
import club.smileboy.app.mlnlco.model.params.store.media.MSRelationShipSaveParam
import club.smileboy.app.mlnlco.repository.MediaRSheetRepository
import club.smileboy.app.mlnlco.service.OperationService
import club.smileboy.app.mlnlco.service.queryassist.MediaRSheetAssist
import club.smileboy.app.mlnlco.util.defaultValue
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 18:29
 * @description 操作服务实现
 **/
@Service
class OperationServiceImpl(private val mediaRSheetRepository: MediaRSheetRepository) : OperationService {

    override fun insertMediaAndSheetRelationShip(msRelationShipSaveParam: MSRelationShipSaveParam) {

        mediaRSheetRepository.selectOne(MediaRSheetAssist.createMediaIdAndSheetIdQueryAssist(msRelationShipSaveParam.mediaId,msRelationShipSaveParam.sheetId))?:
        BeanUtils.transformFrom(msRelationShipSaveParam,MediaRSheetEntity::class.java)!!.apply {
            // mediaType -> mediaTypeId 映射
            mediaTypeId = msRelationShipSaveParam.mediaType
            sheetTypeId = msRelationShipSaveParam.sheetType
            defaultValue()
            mediaRSheetRepository.insert(this)
            return
        }
        val locale = RequestUtil.getRequestLocale()
        val mediaTitle =  when(msRelationShipSaveParam.mediaStoreType) {
            GenericDataDictDataItem.MEDIA_TYPE_AUDIO -> Objects.requireNonNull(ErrorMessageConstraint.evaluateMessageOrNullByLocale(locale,ErrorMessageConstraint.MUSIC_INFO_TITLE.messageCode),msRelationShipSaveParam.mediaTitle)
            else -> TODO()
        }

        throw ExceptionUtil.exception(DataException.CODE,ErrorMessageConstraint.GENERAL_INFO_TWO,locale,mediaTitle)
    }


    override fun deleteMediaAndSheetRelationShip(msRelationShipDeleteParam: MSRelationShipDeleteParam) {
        mediaRSheetRepository.delete(MediaRSheetAssist.createMediaIdAndSheetIdQueryAssist(msRelationShipDeleteParam.mediaId,msRelationShipDeleteParam.sheetId))
    }

    override fun deleteMediaAndSheetRelationShipById(sheetId: Long) {
        mediaRSheetRepository.delete(MediaRSheetAssist.createSheetIdQuery(sheetId))
    }
}