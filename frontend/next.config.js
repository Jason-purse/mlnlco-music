/** @type {import('next').NextConfig} */
const withCSS = require('@zeit/next-css');
const withLess = require('@zeit/next-less')
const webpack = require('webpack');
const withBundleAnalyzer = require("@zeit/next-bundle-analyzer");

module.exports = withBundleAnalyzer(withLess(withCSS({
    reactStrictMode: true,
    swcMinify: true,
    cssModules: false,
    lessLoaderOptions: {
        modifyVars: {
            // 这里的变量优先级更高
            // 详情参考  https://github.com/ant-design/ant-design-pro/issues/9082
            'root-entry-name': 'default'
        },
        javascriptEnabled: true
    }
})));
