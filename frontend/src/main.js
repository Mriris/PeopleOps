import Vue from 'vue';
import Vuex from 'vuex';
import store from './vuex/store';
import App from './App';
import Router from 'vue-router';
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import global from './global';
import scroll from 'vue-seamless-scroll';
import jsCookie from 'js-cookie';
import axios from 'axios';
import VueAxios from 'vue-axios';

Vue.config.productionTip = false;
Vue.use(Router);
Vue.use(scroll);
Vue.use(ElementUI);
Vue.use(VueAxios, axios);
Vue.prototype.$bus = new Vue();
Vue.use(Vuex);
Vue.prototype.$cookie = jsCookie;
Vue.prototype.global = global;

router.beforeEach((to, from, next) => {
  if (to.meta.auth == '1') {  // 需要管理员权限
    // 判断当前是否拥有权限
    if (jsCookie.get('qx') == '1') { // 有权限
      next();
    } else {  // 无权限，跳转到管理员登录页面
      next({ path: '/login' });
    }
  } else { // 不需要权限，直接访问
    next();
  }
});

new Vue({
  el: '#app',
  render: h => h(App),
  router: router,
  store: store
});