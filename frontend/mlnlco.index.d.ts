/**
 * redux 命名空间
 */
import {decl} from "postcss";

export namespace MlnlcoReduxNS {
    /**
     * 组合 State
     */
    declare type ComposeState  = {
       [key: string]: any
    }
    /**
     * action Payload
     */
    declare type Payload = {
        data: Data
    }

    /**
     * Generic Action
     */
    declare type GenericAction = {

        type: string,

        payload: Payload
    }

    /**
     * redux 存储数据类型(payload中包含的data)
     */
    declare type Data = any



}
/**
 * entity 命名空间
 */
export namespace MnlcoEntityNS {

}
/**
 * 组件 命名空间
 */
export namespace MlnlcoComponentNS {

}
/**
 * 认证命名空间
 */
export namespace MlnlcoAuthNS {
    /**
     * 用户信息类型
     */
    declare type USERINFO = {
        isAdmin: boolean
        [key: string]: any
    }
}

/**
 * 后台API 命名空间 声明
 */
export namespace MlnlcoBackEndApiMS {
    /**
     * APIs 集合
     */
    declare type  APIs  =  {
        [key: string]: string
    }
    /**
     * API 响应对象 ...
     */
    declare type API_RESPONSE = {
        data?: API_PAYLOAD,
        code: string,
        message: string
    }
    /**
     * API 响应负载
     */
    declare type API_PAYLOAD = any
}
