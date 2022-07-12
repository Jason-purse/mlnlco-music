import {PropsWithChildren, ReactNode, useEffect} from "react";
import {useSelector} from "react-redux";
import Admin from '../pages/admin'
import {useRouter} from "next/router";
import {MlnlcoReduxNS} from "../mlnlco.index";
import Login from "../pages";
import Redirect from "./redirect";
import './index.less'
import ErrorPage from "../pages/error";

type LayoutProps = {}
/**
 * layout
 * @param props layoutProps 根据属性进行管理端或者 用户端的渲染
 * @constructor
 */
export default function Layout({children}: PropsWithChildren<LayoutProps>) {
    let state = useSelector((state: MlnlcoReduxNS.ComposeState) => state.system)
    let router = useRouter()

    // 在客户端进行判断,是否登录,如果没有登录,执行router ...
    useEffect(() => {
        // @ts-ignore
        if (children.type !== Login && !state.loginStatus) {
            setTimeout(() => {
                router.push("/").catch(error => {
                    console.log("系统出错了 !!!")
                })
            },2000)
        }
    })

    // login / 如果本身就是login
    // @ts-ignore
    if (children.type == Login || children.type == ErrorPage) {
        return <div className="layout-container">
            { children as ReactNode}
        </div>
    }


    return <div className="layout-container">
        {/*@ts-ignore*/}
        {state.loginStatus ? (children.type == Admin ? children:
            (state.isAdmin ? <Admin menus={[]}>{children}</Admin> : <div>user</div>)) : <Redirect />}
    </div>
}

