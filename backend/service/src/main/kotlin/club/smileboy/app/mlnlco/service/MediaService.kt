package club.smileboy.app.mlnlco.service

import club.smileboy.app.mlnlco.model.params.query.resource.MediaQuery
import club.smileboy.app.mlnlco.model.params.store.media.MediaStoreParam
import club.smileboy.app.mlnlco.model.params.store.media.music.MusicStoreParam
import club.smileboy.app.mlnlco.model.vo.MediaResourceVo
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.data.domain.Pageable

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 9:38
 * @description 音乐服务抽象
 **/
interface MediaService {
    /**
     * 根据查询条件查询所有媒体信息且分页
     * @param mediaQuery 媒体查询条件
     * @param pageable 查询条件
     */
    fun findAllMediaInfoByQueryAndPage(mediaQuery: MediaQuery,pageable: Pageable): Page<out MediaResourceVo>

    /**
     * 保存一个媒体信息
     * @param mediaStoreParam 媒体保存参数
     */
    fun insertMediaInfoByParams(mediaStoreParam: MediaStoreParam)

    /**
     * 更新一个媒体信息
     * @param id 媒体id
     * @param mediaStoreParam 媒体更新参数
     */
    fun updateMediaInfoByParams(id: String,mediaStoreParam: MediaStoreParam): MediaResourceVo

    /**
     * 根据id删除一个媒体信息
     * @param id
     */
    fun deleteMediaInfoById(id: String,mediaType: String)
}