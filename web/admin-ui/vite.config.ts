import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// 如果编辑器提示 path 模块找不到，则可以安装一下 @types/node -> npm i @types/node -D
import {resolve} from 'path'

// 按需引入element-plus
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), Components({resolvers: [ElementPlusResolver()]})],
  resolve: {
    alias: {
      '@': resolve(__dirname, 'src') // 设置 `@` 指向 `src` 目录
    }
  },
  base: './', // 设置打包路径
  server: { // 设置服务器
    port: 3000, // 端口
    open: false, // 浏览器是否打开
    cors: true, // 是否跨域

    // 设置代理，根据我们项目实际情况配置 线上用nginx
    proxy: {
      '/api': {
        target: 'http://localhost:8081/moon/',
        changeOrigin: true,
        secure: false,
        rewrite: (path) => path.replace('/api/', '/')
      }
    }
  },
  // 增加scss预处理样式
  css: {
    preprocessorOptions: {
      scss: {
        // @/ 是 src/ 的别名
        // 所以这里假设你有 `src/assets/scss/variables.scss` 这个文件
        additionalData: `@import "@/assets/scss/variables.scss";`
      },
    },
  }
})
