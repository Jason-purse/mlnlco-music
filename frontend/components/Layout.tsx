import MlnlcoAdminLayout from "./admin/MlnlcoAdminLayout";
import MlnlcoUserLayout from "./user/MlnlcoUserLayout";

type LayoutProps = {
    isAdmin: boolean
}
/**
 * layout
 * @param props layoutProps 根据属性进行管理端或者 用户端的渲染
 * @constructor
 */
export default function Layout({isAdmin}: LayoutProps) {
    return (
        isAdmin ? <MlnlcoAdminLayout /> : <MlnlcoUserLayout />
    )
}