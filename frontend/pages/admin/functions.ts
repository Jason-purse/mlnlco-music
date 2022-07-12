import {MenuItem} from "../../model/entities";
import Request,{resultHandler} from '../../service/Request'
import {MlnlcoBackEndApiMS} from "../../mlnlco.index";
type API_RESPONSE = MlnlcoBackEndApiMS.API_RESPONSE;
import {AxiosPromise, AxiosResponse} from "axios";
type APIs =  MlnlcoBackEndApiMS.APIs
const Apis: APIs = {
    getMenus: ""
}

type AdminLayoutApi = {
    /**
     * 获取所有菜单列表 ...
     */
    getMenus():  Promise<MenuItem[] | API_RESPONSE>
}


export default {

    getMenus: () => {
        let promise: Promise<AxiosResponse<MenuItem[]>> = Request.get(Apis.getMenus);
        let result: Promise<MenuItem[] | API_RESPONSE> = resultHandler<MenuItem[]>(promise);
        return result;
    }


} as AdminLayoutApi