<template>
  <el-menu class="aside" router :default-active="$route.path" :default-openeds="openeds">
    <el-menu-item-group>
      <el-menu-item style="text-align: left;" index="/welcome"><i class="el-icon-s-home"></i>首页</el-menu-item>
    </el-menu-item-group>
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-menu"></i>部门管理</template>
      <el-menu-item-group>
        <el-menu-item index="/bmBuild">新建部门</el-menu-item>
        <el-menu-item index="/bmList">部门列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i>员工管理</template>
      <el-menu-item-group>
        <el-menu-item index="/ygBuild">新建员工</el-menu-item>
        <el-menu-item index="/ygList">员工列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="3">
      <template slot="title"><i class="el-icon-s-tools"></i>账户管理</template>
      <el-menu-item-group>
        <el-menu-item index="/changePassword">修改密码</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'aside',
  data () {
    return {
      openeds: []
    }
  }
};
</script>
<style lang="less" scoped>
.aside {
  .el-submenu {
    text-align: left;
  }
  .el-menu-item {
    text-align: center;
  }
}
</style>
