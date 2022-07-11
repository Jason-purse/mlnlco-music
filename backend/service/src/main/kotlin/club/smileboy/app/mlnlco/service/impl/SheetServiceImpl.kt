package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint
import club.smileboy.app.commons.mlnlco.exceptions.DataException
import club.smileboy.app.commons.mlnlco.utils.*
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.entity.MediaSheetEntity
import club.smileboy.app.mlnlco.model.params.store.sheet.DefaultSheetSaveParam
import club.smileboy.app.mlnlco.model.params.store.sheet.DefaultSheetUpdateParam
import club.smileboy.app.mlnlco.model.params.store.sheet.SheetStoreParam
import club.smileboy.app.mlnlco.model.vo.DefaultSheetVo
import club.smileboy.app.mlnlco.model.vo.SheetVo
import club.smileboy.app.mlnlco.repository.SheetRepository
import club.smileboy.app.mlnlco.service.SheetService
import club.smileboy.app.mlnlco.service.queryassist.SheetAssist
import club.smileboy.app.mlnlco.util.UserUtil
import club.smileboy.app.mlnlco.util.defaultValue
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 22:07
 * @description sheet service impl
 **/
@Service
class SheetServiceImpl(private val sheetRepository: SheetRepository) : SheetService {

    override fun findAllSheetInfoByCategory(sheetTypeId: Long): List<SheetVo> {
        return ElvisUtil.assertListNotEmptyAndActionOrDefault(
            sheetRepository.selectList(
                SheetAssist.findAllSheetInfoQueryAssist(
                    sheetTypeId
                )
            ), StreamUtil.doElementTypeMapAction(DefaultSheetVo::class.java)
        ) {
            emptyList()
        }
    }

    override fun insertSheetInfoByParams(sheetSaveParam: DefaultSheetSaveParam) {
        sheetRepository.selectOne(
            SheetAssist.createSheetNameAndCreateIdQuery(
                sheetSaveParam.sheetName,
                UserUtil.getCurrentLoginUser().id
            )
        ) ?: BeanUtils.transformFrom(sheetSaveParam, MediaSheetEntity::class.java)!!.apply {
            userId = UserUtil.getCurrentLoginUser().id
            defaultValue()
            sheetRepository.insert(this)
        }
    }

    override fun updateSheetInfoByParams(id: Long, sheetStoreParam: SheetStoreParam): SheetVo {
        val locale = RequestUtil.getRequestLocale()
        return (sheetStoreParam as DefaultSheetUpdateParam).let {
            ElvisUtil.assertNotNullOrThrow(sheetRepository.selectById(id)) {
                val sheetName = when (sheetStoreParam.sheetType) {
                    GenericDataDictDataItem.SHEET_TYPE_PLAYLIST -> Objects.requireNonNull(
                        ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                            locale,
                            ErrorMessageConstraint.SHEET_PLAYLIST.messageCode
                        )
                    )
                    else -> TODO()
                }
                ExceptionUtil.exception(DataException.CODE, ErrorMessageConstraint.GENERAL_INFO_ZERO, locale, sheetName)
            }.run {
                BeanUtils.updateProperties(sheetStoreParam, this)
                sheetRepository.updateById(this)

                // 更新版本,只需要将version + 1即可 ... 减少一次交互
                // 如果成功了 ...
                version += 1
                BeanUtils.transformFrom(this,DefaultSheetVo::class.java)!!
            }
        }

    }

    override fun deleteSheetInfoById(id: Long) {
        sheetRepository.deleteById(id)
    }
}