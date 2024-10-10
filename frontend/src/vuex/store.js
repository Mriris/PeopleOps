import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 应用初始状态
const state = {
  homeBgimg: false  // 管理主页面的背景图显示设置
}

// 定义所需的 mutations
const mutations = {
  changeHomeBgimg (state, data) {
    state.homeBgimg = data;
  }
}

// 创建 store 实例
export default new Vuex.Store({
  state,    // 数据的异步操作
  // actions,  // 共同维护的一个状态，state里面可以是很多个全局状态
  // getters,  // 获取数据并渲染
  mutations // 处理数据的唯一途径，state的改变或赋值只能在这里
})