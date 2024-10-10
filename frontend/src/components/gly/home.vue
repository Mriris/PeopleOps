<template>
  <div class="home">
    <el-container style="height: 100%">
      <el-header style="border-bottom: solid 1px #e6e6e6;background: #fff">
        <Header />
      </el-header>
      <el-container>
        <el-aside width="20%" style="border-right: solid 1px #e6e6e6;">
          <Aside style="border-right: 0px;" />
        </el-aside>
        <el-main class="mainBg">
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import Header from '@/components/layout/header.vue';
import Aside from '@/components/layout/aside.vue';
export default {
  name: 'home',
  components: { // 引入头部组件
    Header,
    Aside
  }
};
</script>
<style lang="less" scoped>
.home {
  width: 100%;
  background: #fff;
  height: 100%;
  .el-container {
    height: auto;
  }
}
</style>