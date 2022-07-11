package club.smileboy.app.mlnlco.model.params.store.user;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 18:36
 * @description 用户存储参数 抽象 ...
 **/
public interface UserStoreParam {

    /**
     * 创建默认的常用UserStoreParam
     * @return userStoreParam 实例
     */
    static UserStoreParam userStoreParam() {
        return new DefaultUserStoreParam();
    }


}

