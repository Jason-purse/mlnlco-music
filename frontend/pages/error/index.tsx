import {PropsWithChildren} from "react";
import './index.less'
type ErrorProps = {
    message: string
}
export default function ErrorPage({message}: PropsWithChildren<ErrorProps>) {
    return (
        <div className="error-container">
            出错了
        </div>
    )
}