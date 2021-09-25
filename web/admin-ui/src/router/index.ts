import {createRouter, createWebHashHistory, RouteRecordRaw} from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/home.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login.vue') // 懒加载组件
  },
  {
    path: '/vuex',
    name: 'Vuex',
    component: () => import('@/views/vuex.vue') // 懒加载组件
  },
  {
    path: '/axios',
    name: 'Axios',
    component: () => import('@/views/axios.vue') // 懒加载组件
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
