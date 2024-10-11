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

import gwList from '@/components/gly/gwList'
import gwDetail from '@/components/gly/gwDetail'
import gwBuild from '@/components/gly/gwBuild'
import gwUpdate from '@/components/gly/gwUpdate'

import syList from '@/components/gly/syList'
import syDetail from '@/components/gly/syDetail'
import syBuild from '@/components/gly/syBuild'
import syUpdate from '@/components/gly/syUpdate'

import lzList from '@/components/gly/lzList'
import lzDetail from '@/components/gly/lzDetail'
import lzBuild from '@/components/gly/lzBuild'
import lzUpdate from '@/components/gly/lzUpdate'

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
          path: '/gwList',
          name: 'gwList',
          component: gwList,
          meta: { auth: '1' }
        },
        {
          path: '/gwDetail',
          name: 'gwDetail',
          component: gwDetail,
          meta: { auth: '1' }
        },
        {
          path: '/gwBuild',
          name: 'gwBuild',
          component: gwBuild,
          meta: { auth: '1' }
        },
        {
          path: '/gwUpdate',
          name: 'gwUpdate',
          component: gwUpdate,
          meta: { auth: '1' }
        },
        {
          path: '/syList',
          name: 'syList',
          component: syList,
          meta: { auth: '1' }
        },
        {
          path: '/syDetail',
          name: 'syDetail',
          component: syDetail,
          meta: { auth: '1' }
        },
        {
          path: '/syBuild',
          name: 'syBuild',
          component: syBuild,
          meta: { auth: '1' }
        },
        {
          path: '/syUpdate',
          name: 'syUpdate',
          component: syUpdate,
          meta: { auth: '1' }
        },
        {
          path: '/lzList',
          name: 'lzList',
          component: lzList,
          meta: { auth: '1' }
        },
        {
          path: '/lzDetail',
          name: 'lzDetail',
          component: lzDetail,
          meta: { auth: '1' }
        },
        {
          path: '/lzBuild',
          name: 'lzBuild',
          component: lzBuild,
          meta: { auth: '1' }
        },
        {
          path: '/lzUpdate',
          name: 'lzUpdate',
          component: lzUpdate,
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
