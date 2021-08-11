import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    resolve: {
        /*alias: {}*/
    },
    base: './', // 设置打包路径
    server: { // 设置服务器
        port: 3000, // 端口
        open: false, // 浏览器是否打开
        cors: true, // 是否跨域

        // 设置代理，根据我们项目实际情况配置
        proxy: {
            '/api': {
                target: 'http://localhost:8000',
                changeOrigin: true,
                secure: false,
                rewrite: (path) => path.replace('/api/', '/')
            }
        }
    }
})
