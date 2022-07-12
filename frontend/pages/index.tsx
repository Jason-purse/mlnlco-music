import type {NextPage} from 'next'
import Link from 'next/link'
import './index.less'
import {useDispatch, useSelector, useStore} from "react-redux";
import {configAdmin, setUserInfo} from "../store/reducers/action";
import {useRouter} from "next/router";
import {MlnlcoReduxNS} from "../mlnlco.index";
import Redirect from "../components/redirect";
type ComposeState = MlnlcoReduxNS.ComposeState;

const Home: NextPage = () => {
    let {loginStatus, isAdmin} = useSelector((state: ComposeState) => state.system)
    let dispatch = useDispatch();
    let router = useRouter()

    if (loginStatus) {
        router.push(isAdmin ? '/admin' : '/user')
        console.log("登录了,跳转dashboard")
        // 不渲染这个组件
        return null
    }
    return (
        <div className="index-container">
            <Link href="/">
                <a onClick={() => {
                    dispatch(setUserInfo({isAdmin: true}))
                }}>admin</a>
            </Link>
            <br/>
            <Link href="user">
                <a>user</a>
            </Link>
        </div>
    )
}

export default Home
