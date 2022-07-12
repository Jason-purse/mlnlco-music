import adminReducer from './admin'
import userReducer from './user'
import {combineReducers, Reducer} from 'redux'
import {MlnlcoReduxNS} from "../../mlnlco.index";
import {IS_ADMIN, SET_ADMIN_LOGIN, SET_USER_LOGIN} from "./types";

type SystemState = {
    isAdmin: boolean,
    loginStatus: boolean
}


type SystemAction = MlnlcoReduxNS.GenericAction

/**
 * 系统 reducer ...
 * @param state state
 * @param type action tupe
 * @param payload 负载数据
 */
const systemReducer: Reducer<SystemState, SystemAction> = (state: SystemState = {
    isAdmin: true,
    loginStatus: false
}, {type, payload}: SystemAction) => {
    switch (type) {
        case IS_ADMIN:
            return {
                ...state,
                isAdmin: payload.data as boolean,
            }
        case SET_ADMIN_LOGIN:
        case SET_USER_LOGIN:
            return {
                ...state,
                isAdmin: payload.data.isAdmin,
                loginStatus: true
            }
        default:
            return state;
    }
}

export default combineReducers({
    admin: adminReducer,
    user: userReducer,
    system: systemReducer
})