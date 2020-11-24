import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8081/moon/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios

Vue.config.productionTip = false;

//
router.beforeEach(((to, from, next) => {

    if (to.meta.requireAuth) {
        if (store.state.user.username) {
            next()
        } else {
            next({
                path: 'login',
                query: {redirect: to.fullPath}
            })
        }
    } else {
        next()
    }

}))

new Vue({
    el: '#app',
    router,
    render: h => h(App),
    store,
    components: {App},
    template: '<App/>'
}).$mount("#app");
