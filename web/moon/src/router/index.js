import Vue from "vue";
import VueRouter from "vue-router";

// 导入刚才编写的组件
import AppIndex from '@/components/AppIndex'
import Login from '@/components/Login'

Vue.use(VueRouter);

const routes = [
  // 下面都是固定的写法
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/index',
    name: 'AppIndex',
    component: AppIndex
  }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
