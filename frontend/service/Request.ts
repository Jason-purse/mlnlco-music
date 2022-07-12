import axios, {AxiosInstance, AxiosResponse} from 'axios'
import {MlnlcoBackEndApiMS} from "../mlnlco.index";
import {data} from "browserslist";

type API_RESPONSE = MlnlcoBackEndApiMS.API_RESPONSE;
type API_PAYLOAD = MlnlcoBackEndApiMS.API_PAYLOAD;

const Request: AxiosInstance = axios.create({
    /**
     * 基本url 路径
     */
    baseURL: process.env.BACKEND_API_BASEURL,
    /**
     * 5s
     */
    timeout: 5000
})


// /**
//  * 增加一个请求拦截器
//  */
// Request.interceptors.request.use(value => {
//
// },error => {
//
// })
/**
 * 增加一个错误拦截器 ...
 */
Request.interceptors.response.use(response => {
    console.log("拦截器处理")
    // 这个范围内的属于正确响应的 ...
    if (response.status >= 200 || response.status < 300) {
        // 返回数据
        return response.data as API_PAYLOAD
    }

    // 直接判定服务器错误 ....
    return {
        code: "500",
        message: "Server Internal Error !!"
    } as API_RESPONSE


}, error => {
    console.log("拦截器处理")
    // 返回消息 ...
    return {
        code: '500',
        message: "Server Internal Error !!"
    } as API_RESPONSE
})
/**
 * 结果处理器
 * @param response promise<AxiosResponse>
 */
export const resultHandler: <T>  (response: Promise<AxiosResponse<T>>) => Promise<T | API_RESPONSE> = response => {
    return new Promise((resolve, reject) => {
        response.then(data => {
            resolve(data  as  any)
        }, error => {
            // 如果还有其他错误 ...
            reject(error)
        })
    })
}


export default Request;
