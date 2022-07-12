import StatisticComponent, {StatisticData} from "../statistic/StatisticComponent";
import {Layout} from "antd";
import React from "react";
import {Content, Footer, Header} from "antd/es/layout/layout";

/**
 * 管理layoutProps
 */
type DashboardProps = {
    /**
     * 资源统计数据
     */
    resData: StatisticData[],


}
export default function DashBoard({resData}: DashboardProps) {
    return (
        <>
            <Layout className="dashboardContainer">
                <Header
                    className="statistics-box"
                >
                    {
                        resData.map(ele => {
                            return (
                                <StatisticComponent {...ele} />
                            )
                        })
                    }
                </Header>
                <Content
                    className="site-layout-background"
                    style={{
                        margin: '24px 16px',
                        padding: 24,
                        minHeight: 280,
                    }}
                >
                    这是一段文本
                </Content>
                <Footer>
                    这是底部
                </Footer>
            </Layout>
        </>
    )
}
