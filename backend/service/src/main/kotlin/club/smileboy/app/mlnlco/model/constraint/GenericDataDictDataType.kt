package club.smileboy.app.mlnlco.model.constraint
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:32
 * @description 通用的 数据字典类型
 **/
class GenericDataDictDataType {
    companion object {
        /**
         * 用户类型
         */
        const val USER_TYPE = "user_type"

        /**
         * 资源类型
         */
        const val RESOURCE_TYPE = "resource_type"

        /**
         * sheet type
         */
        const val SHEET_TYPE = "sheet_type"

        /**
         * 所有其他类型的 总类型(根节点标识)
         */
        const val SYSTEM_TYPE = "system_type"

        /**
         * 它仅仅指示做一个标识,没有实际应用到字典中
         */
        const val SYSTEM_CHILD_TYPE = "system_child_type"
    }
}

class GenericDataDictDataItem {
   companion object {
       /**
        * 普通用户
        */
       const val USER_TYPE_NORMAL_USER = "normal user"

       /**
        * 管理员
        */
       const val USER_TYPE_ADMIN = "admin"

       /**
        * 资源类型之 媒体类型
        */
       const val RESOURCE_TYPE_MEDIA = "media"

       /**
        * 媒体类型之 音频
        */
       const val MEDIA_TYPE_AUDIO = "audio"

       /**
        * 媒体类型之 视频
        */
       const val MEDIA_TYPE_VIDEO = "video"

       /**
        * 歌单
        */
       const val SHEET_TYPE_PLAYLIST = "playlist"

       /**
        * 收藏
        */
       const val SHEET_TYPE_COLLECTION = "collection"

   }
}


