import Vue from 'vue'
import Router from 'vue-router'

import login from '@/components/gly/login'

import home from '@/components/gly/home'
import welcome from '@/components/gly/welcome'

import ygList from '@/components/gly/ygList'
import ygDetail from '@/components/gly/ygDetail'
import ygBuild from '@/components/gly/ygBuild'
import ygUpdate from '@/components/gly/ygUpdate'

import changePassword from '@/components/gly/changePassword'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '*',  // 首页重定向
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/home',
      name: 'home',
      component: home,
      meta: { auth: '1' },
      children: [
        {
          path: '/welcome',
          name: 'welcome',
          component: welcome,
          meta: { auth: '1' }
        },
        {
          path: '/ygList',
          name: 'ygList',
          component: ygList,
          meta: { auth: '1' }
        },
        {
          path: '/ygDetail',
          name: 'ygDetail',
          component: ygDetail,
          meta: { auth: '1' }
        },
        {
          path: '/ygBuild',
          name: 'ygBuild',
          component: ygBuild,
          meta: { auth: '1' }
        },
        {
          path: '/ygUpdate',
          name: 'ygUpdate',
          component: ygUpdate,
          meta: { auth: '1' }
        },
        {
          path: '/changePassword',
          name: 'changePassword',
          component: changePassword,
          meta: { auth: '1' }
        }
      ]
    }
  ]
})
