import {
    MenuFoldOutlined,
    MenuUnfoldOutlined,
    UploadOutlined,
    UserOutlined,
    VideoCameraOutlined,
} from '@ant-design/icons';
import {Layout, Menu} from 'antd';
import React, {PropsWithChildren, ReactElement, useEffect, useState} from 'react';
import Link from 'next/link'
import AdminLayoutApi from './functions'
import {MlnlcoBackEndApiMS} from '../../mlnlco.index'

type API_RESPONSE = MlnlcoBackEndApiMS.API_RESPONSE


const {Header, Sider, Content} = Layout;
import './index.less'
import {menus} from "../api/admin/menus";
import {MenuItem} from "../../model/comp-types";
import {GetServerSideProps} from "next";
import {useRouter} from "next/router";


/**
 * 管理layout props
 */
type AdminLayoutProps = {
    /**
     * 菜单列表
     */
    menus: MenuItem[],
    /**
     * 菜单选择 keys
     */
    selectKeys?: string[],

    /**
     * 是否折叠了 侧边栏
     */
    collapsed?: boolean,

    logo?: any,
    /**
     * 服务端数据抓取异常 ...
     */
    message?: string,

} & PropsWithChildren

// @ts-ignore
// @ts-ignore
/**
 * mlnlco Layout ....
 * @param props
 * @constructor
 */
export default function Index({menus = [], selectKeys = [], collapsed = false, logo = '', children,message}: AdminLayoutProps) {
    console.log(children)
    // 初始值继承于这个 .... props -collapsed
    const [sbCollapsed, setCollapsed] = useState(collapsed);
    // 路由出口页面 ...刚开始是空的
    const [outlet, setOutlet] = useState(null)
    const [siderBarWidth, setSiderBarWidth] = useState('300px')
    let router = useRouter()
    useEffect(() => {
        // 如果存在错误 ...
        if(message) {
            router.push("/error")
        }
    })
    if(message) {
        return <>出错啦 !!!!</>
    }

    return (
        <>
            <Layout className="adminLayout">
                <Sider className="sider-bar" width={siderBarWidth} collapsible collapsed={sbCollapsed}>
                    <div className="logo">
                        {!sbCollapsed ? <span className="content">{logo ? logo : "Mlnlco Admin"}</span> : ''}
                        <span className={sbCollapsed ? 'triggerContainer-center' : 'triggerContainer'}>
                            {React.createElement(sbCollapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
                                className: 'trigger',
                                onClick: () => setCollapsed(!sbCollapsed),
                            })}
                        </span>
                    </div>
                    <hr className="baseLine"/>
                    <Menu
                        className="menus"
                        theme="dark"
                        mode="inline"
                        defaultSelectedKeys={selectKeys}
                        items={menus.map(({key, label, icon, path, value}) => {
                            return {
                                key,
                                value,
                                label: (<Link href={{
                                    pathname: path,
                                    query: {
                                        logo,
                                        collapsed: sbCollapsed
                                    }
                                }} shallow={true}>
                                    <a className="menu-item">{label}</a>
                                </Link>)
                            }
                        })}
                    />
                </Sider>
                <Layout className="site-layout">
                    {children}
                </Layout>
            </Layout>
        </>
    );
}

/**
 * 获取Props
 */
export const getServerSideProps: GetServerSideProps = async ({req}) => {

    let result = await AdminLayoutApi.getMenus();
    console.log(result)
    let val = result as API_RESPONSE
    if (val.message) {
        return {
           props: {
               menus: [],
               message: "error"
           }
        }
    }
    /**
     * 查询menus ....
     */
    return {
        props: {
            menus: (result as MenuItem[])
        }
    }
};
