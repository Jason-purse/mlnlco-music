package club.smileboy.app.mlnlco.controller

import club.smileboy.app.mlnlco.model.params.query.resource.music.MusicQuery
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicSaveParam
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicStoreParam
import club.smileboy.app.mlnlco.model.vo.MediaResourceVo
import club.smileboy.app.mlnlco.model.vo.MusicResourceVo
import club.smileboy.app.mlnlco.service.MediaService
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import io.swagger.annotations.Api
import org.springframework.data.domain.Pageable
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * 音乐接口列表
 */
@Api("音乐接口列表")
@RestController
@RequestMapping("api/mlnlco/v1/music")
class MusicResourceController(private val musicService: MediaService) {

    /**
     * 根据音乐查询条件查询音乐资源并分页
     * @param musicQuery 音乐搜索条件
     * @param pageable 分页条件
     */
    @GetMapping
    fun findAllMusicInfoByPageAndParams(musicQuery: MusicQuery, pageable: Pageable): Page<out MediaResourceVo> {
        return musicService.findAllMediaInfoByQueryAndPage(musicQuery, pageable)
    }

    /**
     * 根据音乐存储参数保存一个音乐信息
     * @param musicSaveParam 音乐保存参数
     * @return 保存结果
     */
    @PostMapping
    fun insertMusicInfoByParams(@RequestBody musicSaveParam: MusicSaveParam) {
        return musicService.insertMediaInfoByParams(musicSaveParam)
    }

    /**
     * 根据音乐参数更新一个音乐信息
     * @param id 音乐信息 id
     * @param musicStoreParam 音乐更新参数
     * @return 更新结果
     */
    @PutMapping("{id}")
    fun updateMusicInfoByParams(
        @PathVariable("id") id: String,
        @RequestBody musicStoreParam: MusicStoreParam
    ): MediaResourceVo {
        return musicService.updateMediaInfoByParams(id, musicStoreParam)
    }

    /**
     * 根据id删除一个音乐信息
     * @param id 音频id 信息
     * @param mediaType 媒体类型
     */
    @DeleteMapping("{mediaType}/{id}")
    fun deleteMusicInfoById(@PathVariable("id") id: String, @PathVariable("mediaType") mediaType: String) {
        return musicService.deleteMediaInfoById(id, mediaType)
    }
}


