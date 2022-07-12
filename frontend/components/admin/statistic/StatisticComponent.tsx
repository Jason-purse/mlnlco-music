import Link from 'next/link'
import exp from "constants";

export type StatisticData = {
    name: string, // 名称
    total: number,// 总数
    exp: boolean, // 指标(上升还是下降)
    routePageUrl: string // 动态路由组件路径
}

const viewData = {
    hrefTip: "查看详情"
}
/**
 * 默认的统计小组件
 *
 * @param props
 * @constructor
 */
export default function StatisticComponent({routePageUrl, name, total,exp}: StatisticData) {
    return (
        <>
            <div className="statisticContainer">
                <article className="item">
                    <header>
                        <div>
                            <div className="name">{name}</div>
                            <div className="exp">{
                               exp?'↑': "👇"
                            }</div>
                        </div>
                        <div className="total-text">{total}</div>
                    </header>
                    <footer>
                        <Link href={routePageUrl}>
                            <a>{viewData.hrefTip}</a>
                        </Link>
                    </footer>
                </article>
            </div>
        </>
    )
}
