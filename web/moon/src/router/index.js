import Vue from "vue";
import VueRouter from "vue-router";

// 导入刚才编写的组件
import AppIndex from '@/components/AppIndex'
import Login from '@/components/Login'
import Home from "../components/Home";
import LibraryIndex from "../components/library/LibraryIndex";

Vue.use(VueRouter);

const routes = [
    // 下面都是固定的写法
    {
        path: '/home',
        name: 'Home',
        component: Home,
        // home页面不需要被访问
        redirect: '/index',
        children: [
            {
                path: '/index',
                name: 'AppIndex',
                component: AppIndex,
                meta: {
                    requireAuth: true
                }
            },
            {
                path: '/library',
                name: 'Library',
                component: LibraryIndex,
                meta: {
                    requireAuth: true
                }
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    }
];

const router = new VueRouter({
    mode: 'history',
    routes
});

export default router;
