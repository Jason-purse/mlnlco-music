import {NextApiHandler} from "next";

export const menus = [
    {
        key: 'dashboard',
        label: 'dashboard',
        path: '/admin/dashboard'
    },
    {
        key: 'resource',
        label: '资源管理',
        path: '/admin/dashboard'
    },
    {
        key: 'profile',
        label: '个人设置',
        path: '/admin/dashboard'
    },
];

/**
 * 获取 admin layout的所有菜单信息
 * @param req req
 * @param res res
 */
const handler : NextApiHandler =  (req, res) =>  {
    res.status(200).json(menus);
}