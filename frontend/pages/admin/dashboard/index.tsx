import Admin from '../../admin'
export default function Dashboard({menus}: any) {
    return (
        <Admin menus={menus}>

        </Admin>
    )
}

export  async  function  getStaticProps(context: any) {
    console.log("执行静态数据抓取")
    return {
        props: {
            menus: []
        }
    }
}