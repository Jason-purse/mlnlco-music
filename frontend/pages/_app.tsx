import '../styles/globals.css'
import 'antd/es/style/themes/default.less';
import 'antd/dist/antd.less';
import '../styles/theme.less'
import type {AppProps} from 'next/app'
import Layout from "../components/Layout";
import {Provider} from "react-redux";
import {useStore} from "../store";

function MyApp({Component, pageProps}: AppProps) {
    return (
        <Provider store={useStore(pageProps.initialState)}>
            {/*@ts-ignore*/}
            <Layout>
                <Component {...pageProps} />
            </Layout>
        </Provider>
    )
}

export default MyApp
