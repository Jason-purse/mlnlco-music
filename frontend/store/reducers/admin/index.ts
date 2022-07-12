import {Reducer} from "redux";
import {MlnlcoAuthNS, MlnlcoReduxNS} from "../../../mlnlco.index";
import {SET_ADMIN_LOGIN} from "../types";

/**
 * admin state
 */
type AdminState = {
    info?: MlnlcoAuthNS.USERINFO
}

type AdminAction = MlnlcoReduxNS.GenericAction

/**
 * admin reducer ...
 * @param state state
 * @param type action type
 * @param payload 负载
 */
const adminReducer: Reducer<AdminState, AdminAction> = (state: AdminState = {}, {type,payload}: AdminAction) => {
    switch (type) {
        case SET_ADMIN_LOGIN:
            return {
                ...state,
                info: payload.data
            }
        default:
            return state
    }
}

export default adminReducer;