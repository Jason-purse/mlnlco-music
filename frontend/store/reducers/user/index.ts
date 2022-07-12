import {Reducer} from "redux";
import {MlnlcoAuthNS, MlnlcoReduxNS} from "../../../mlnlco.index";
import {SET_USER_LOGIN} from "../types";

/**
 * admin state
 */
type UserState = {
    info?: MlnlcoAuthNS.USERINFO
}

type UserAction = MlnlcoReduxNS.GenericAction
/**
 * 用户 reducer
 * @param state state
 * @param type action type
 * @param payload 负载
 */
const userReducer: Reducer<UserState, UserAction> = (state: UserState = {}, {type,payload}: UserAction) => {
    switch (type) {
        case SET_USER_LOGIN:
            return {
                ... state,
                info: payload.data
            }
        default:
            return state;
    }
}

export default userReducer;