/**
 * 菜单项
 */
export type MenuItem = {
    /**
     * label
     */
    label: string,
    /**
     * value
     */
    value: string,
    /**
     * key
     */
    key: string,
    /**
     * icon
     */
    icon: string,
    /**
     * 组件路径(绝对路径)
     */
    path: string,
    /**
     * 子菜单
     */
    children: MenuItem[]
}