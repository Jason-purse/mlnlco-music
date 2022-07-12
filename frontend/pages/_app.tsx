import '../styles/globals.css'
import 'antd/es/style/themes/default.less';
import 'antd/dist/antd.less';
import '../styles/theme.less'
import type { AppProps } from 'next/app'

function MyApp({ Component, pageProps }: AppProps) {
  return <Component {...pageProps} />
}

export default MyApp
