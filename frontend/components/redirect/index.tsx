import {PropsWithChildren, useEffect, useRef} from "react";
import './index.less'

/**
 * 重定向 缓冲界面 ...
 * @param props props ...
 */
export default function Redirect(props: PropsWithChildren<any>) {

    let [container]: any = useRef<HTMLElement>(null)
    return (
        <div className="redirect-container" ref={container}>
            重定向中 .....
        </div>
    )
}