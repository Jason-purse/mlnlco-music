import {MlnlcoReduxNS} from "../../mlnlco.index";
import {IS_ADMIN, SET_ADMIN_LOGIN, SET_USER_LOGIN} from "./types";
import exp from "constants";

type Data = MlnlcoReduxNS.Data;
type Action = MlnlcoReduxNS.GenericAction

/**
 * 配置是否为admin
 * @param isAdmin true / false
 */
export const configAdmin: (data: Data) => Action = (isAdmin) => {
    return {
        type: IS_ADMIN,
        payload: {data: isAdmin}
    }
}
/**
 * 设置用户/ 管理员信息
 * @param data 用户员信息
 */
export const setUserInfo: (data: Data) => Action = (data) => {
    return (data.isAdmin && {
        type: SET_ADMIN_LOGIN,
        payload: {data}
    }) || {
        type: SET_USER_LOGIN,
        payload: {data}
    }
}