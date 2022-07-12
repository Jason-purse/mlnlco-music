import Admin from '../../admin'
import {menus} from "../../api/admin/menus";
import {MenuItem} from "../../../model/comp-types";
import {useRouter} from "next/router";

type DashboardType = {
    menus: MenuItem[]
}
export default function Dashboard({menus}: DashboardType) {
    const {query} = useRouter()
    return (
        <div>
            你好啊
            dashboard
        </div>
    )
}

export async function getStaticProps(context: any) {
    console.log("执行静态数据抓取")
    return {
        props: {
            menus: menus
        }
    }
}