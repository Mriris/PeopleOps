import Vue from 'vue'
import Router from 'vue-router'

import login from '@/components/gly/login'

import home from '@/components/gly/home'
import welcome from '@/components/gly/welcome'

import ygList from '@/components/gly/ygList'
import ygDetail from '@/components/gly/ygDetail'
import ygBuild from '@/components/gly/ygBuild'
import ygUpdate from '@/components/gly/ygUpdate'

import bmList from '@/components/gly/bmList'
import bmDetail from '@/components/gly/bmDetail'
import bmBuild from '@/components/gly/bmBuild'
import bmUpdate from '@/components/gly/bmUpdate'

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
          path: '/bmList',
          name: 'bmList',
          component: bmList,
          meta: { auth: '1' }
        },
        {
          path: '/bmDetail',
          name: 'bmDetail',
          component: bmDetail,
          meta: { auth: '1' }
        },
        {
          path: '/bmBuild',
          name: 'bmBuild',
          component: bmBuild,
          meta: { auth: '1' }
        },
        {
          path: '/bmUpdate',
          name: 'bmUpdate',
          component: bmUpdate,
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
