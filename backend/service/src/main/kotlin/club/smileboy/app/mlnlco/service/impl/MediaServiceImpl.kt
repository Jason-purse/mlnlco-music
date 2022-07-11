package club.smileboy.app.mlnlco.service.impl

import club.smileboy.app.commons.mlnlco.constraints.ErrorMessageConstraint
import club.smileboy.app.commons.mlnlco.exceptions.DataException
import club.smileboy.app.commons.mlnlco.utils.*
import club.smileboy.app.mlnlco.model.constraint.GenericDataDictDataItem
import club.smileboy.app.mlnlco.model.entity.MusicEntity
import club.smileboy.app.mlnlco.model.params.query.resource.MediaQuery
import club.smileboy.app.mlnlco.model.params.query.resource.music.MusicQuery
import club.smileboy.app.mlnlco.model.params.store.media.MediaStoreParam
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicSaveParam
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicStoreParam
import club.smileboy.app.mlnlco.model.vo.MediaResourceVo
import club.smileboy.app.mlnlco.model.vo.MusicResourceVo
import club.smileboy.app.mlnlco.repository.MusicRepository
import club.smileboy.app.mlnlco.service.MediaService
import club.smileboy.app.mlnlco.service.queryassist.MusicQueryAssist
import club.smileboy.app.mlnlco.util.defaultValue
import club.smileboy.app.mlnlco.util.isNotBlankForBool
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 9:38
 * @description 媒体服务实现
 **/
@Service
class MediaServiceImpl(private val musicRepository: MusicRepository) : MediaService {
    override fun findAllMediaInfoByQueryAndPage(mediaQuery: MediaQuery, pageable: Pageable): Page<out MediaResourceVo> {
        return when (mediaQuery.mediaType) {
            GenericDataDictDataItem.MEDIA_TYPE_AUDIO -> findAllMusicInfoByQueryAndPage(
                mediaQuery as MusicQuery,
                pageable
            )
            else -> TODO()
        }

    }

    /**
     *  根据查询条件获取所有音乐信息 且分页
     *  @see MusicQueryAssist 音乐查询 Query 助手
     */
    private fun findAllMusicInfoByQueryAndPage(musicQuery: MusicQuery, pageable: Pageable): Page<MusicResourceVo> {
        val page = Page.of<MusicEntity>(pageable.pageNumber.toLong(), pageable.pageSize.toLong())
        return musicRepository.selectPage(page, MusicQueryAssist.findAllMusicInfoQueryAssist(musicQuery)).run {
            ElvisUtil.assertNotNullAndActionOrDefault(
                records, StreamUtil.doElementTypeMapAction(MusicResourceVo::class.java), LambdaFunctionUtil.supplier(
                    emptyList()
                )
            ).let {
                Page.of<MusicResourceVo?>(current, size, total).apply {
                    records = records
                }
            }
        }
    }

    override fun insertMediaInfoByParams(mediaStoreParam: MediaStoreParam) {
        return when (mediaStoreParam.mediaStoreType) {
            GenericDataDictDataItem.MEDIA_TYPE_AUDIO -> insertMusicInfoByParams(mediaStoreParam as MusicSaveParam)
            else -> TODO()
        }
    }

    /**
     * 通过音乐参数保存一个音乐信息
     * @param musicStoreParam 音乐信息 ...
     * TODO 通过媒体库进行 歌曲本身的信息解析 ..
     */
    private fun insertMusicInfoByParams(musicSaveParam: MusicSaveParam) {
        val locale = RequestUtil.getRequestLocale()
        musicRepository.selectOne(MusicQueryAssist.createSaveMusicInfoQuery(musicSaveParam, locale))
            ?: BeanUtils.transformFrom(
                musicSaveParam,
                MusicEntity::class.java
            )!!.let {
                it.defaultValue()
                musicRepository.insert(it)
                return
            }

        val musicName = String.format(
            Objects.requireNonNull(
                ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                    locale,
                    ErrorMessageConstraint.MUSIC_INFO_TITLE.messageCode
                )
            ), musicSaveParam.name
        )
        val album = Objects.requireNonNull(
            ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                locale,
                ErrorMessageConstraint.MUSIC_INFO_ALBUM.messageCode
            )
        )
        val singer = Objects.requireNonNull(
            ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                locale,
                ErrorMessageConstraint.MUSIC_INFO_SINGER.messageCode
            )
        )
        val conflict = Objects.requireNonNull(
            ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                locale,
                ErrorMessageConstraint.CONFLICT.messageCode
            )
        )

        // 比如,音乐已存在,歌手,专辑,歌曲名存在冲突 ..
        // 比如,音乐已存在,歌手,专辑,歌曲名存在冲突 ..
        throw ExceptionUtil.exception(
            DataException.CODE,
            ErrorMessageConstraint.USER_INFO_ONE,
            locale,
            musicName,
            "$singer, $album, $musicName, $conflict"
        )
    }

    override fun updateMediaInfoByParams(id: String, mediaStoreParam: MediaStoreParam): MediaResourceVo {
        return when (mediaStoreParam.mediaStoreType) {
            GenericDataDictDataItem.MEDIA_TYPE_AUDIO -> updateMusicInfoByParams(id, mediaStoreParam as MusicStoreParam)
            else -> TODO()
        }
    }

    /**
     * 更新音频媒体信息
     * 仅更新 歌词 / 歌曲描述 ...
     *
     * @param musicStoreParam 媒体更新信息
     */
    private fun updateMusicInfoByParams(id: String, musicStoreParam: MusicStoreParam): MusicResourceVo {

        val musicSubject = Objects.requireNonNull(
            ErrorMessageConstraint.evaluateMessageOrNullByLocale(
                RequestUtil.getRequestLocale(),
                ErrorMessageConstraint.MUSIC.messageCode
            )
        )
        // 音乐是否存在
        ElvisUtil.assertNotNullOrThrow(
            musicRepository.selectById(id),
            LambdaFunctionUtil.supplier(
                ExceptionUtil.exception(
                    DataException.CODE,
                    ErrorMessageConstraint.GENERIC_INFO_ZERO,
                    RequestUtil.getRequestLocale(),
                    musicSubject
                )
            )
        ).apply {
            musicStoreParam.description.isNotBlankForBool()?.let {  description = musicStoreParam.description }
            // TODO 歌词
            // update
            musicRepository.updateById(this)
        }
        TODO()
    }

    override fun deleteMediaInfoById(id: String,mediaType: String) {
        when(mediaType) {
            GenericDataDictDataItem.MEDIA_TYPE_AUDIO ->  deleteMusicInfoById(mediaType)
            else -> TODO()
        }
    }

    /**
     * 根据id 删除一个音乐信息
     * @param id 音频id
     */
    private fun deleteMusicInfoById(id: String) {
        musicRepository.deleteById(id)
    }

    private fun deleteVideoInfoById(id: String) {
        TODO()
    }
}