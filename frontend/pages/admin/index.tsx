import {
    MenuFoldOutlined,
    MenuUnfoldOutlined,
    UploadOutlined,
    UserOutlined,
    VideoCameraOutlined,
} from '@ant-design/icons';
import {Layout, Menu} from 'antd';
import React, {useState} from 'react';
import Link from 'next/link'

const {Header, Sider, Content} = Layout;
import './index.less'



type AdminLayoutProps = {
    menus: any,

}

/**
 * 可能会用到的图标 ...
 */
const iconMap: {[key: string]:  any | {icon: React.ReactElement |any,component: any} } = {
    "1": {icon: UserOutlined,component: () => <div>one</div>},
    '2': {icon: VideoCameraOutlined,component: () => <div>two</div>},
    '3': {icon: UploadOutlined,component: () => <div>three</div>}
}


/**
 * mlnlco Layout ....
 * @param props
 * @constructor
 */
export default function Index({menus}: AdminLayoutProps) {
    const [collapsed, setCollapsed] = useState(false);
    const [defaultKeys,setDefaultKeys] = useState(['1'])
    // 路由出口页面 ...刚开始是空的
    const [outlet, setOutlet] = useState(null)
    const [siderBarWidth, setSiderBarWidth] = useState('300px')
    return (
        <>
            <Layout className="adminLayout">
                <Sider className="sider-bar" width={siderBarWidth} collapsible collapsed={collapsed}>
                    <div className="logo">
                        {!collapsed ? <span className="content">Mlnlco Admin</span> : ''}
                        <span className={collapsed ? 'triggerContainer-center' : 'triggerContainer'}>
                            {React.createElement(collapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
                                className: 'trigger',
                                onClick: () => setCollapsed(!collapsed),
                            })}
                        </span>
                    </div>
                    <hr className="baseLine"/>
                    <Menu
                        className="menus"
                        theme="dark"
                        mode="inline"
                        defaultSelectedKeys={defaultKeys}
                        items={menus.map((ele: { key: string,label: string,path: string,icon: () => React.ReactElement; }) => {
                            return {
                                ... ele,
                                icon: React.createElement(iconMap[ele.key].icon),
                                label: (<Link href={ele.path} shallow={true}>
                                    <a>{ele.label}</a>
                                </Link>)
                            }
                        })}
                    />
                </Sider>
                <Layout className="site-layout">
                    {outlet}
                </Layout>
            </Layout>
        </>
    );
}

/**
 * 获取Props
 */
export async function getStaticProps(context: any) {

    return {
        props: {
            menus: [
                {
                    key: '1',
                    label: 'nav 1',
                    path: '/admin/dashboard'
                },
                {
                    key: '2',
                    label: 'nav 2',
                    path: 'dashboard'
                },
                {
                    key: '3',
                    label: 'nav 3',
                    path: 'dashboard'
                },
            ]
        }
    }
};
