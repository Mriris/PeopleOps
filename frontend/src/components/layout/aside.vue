<template>
  <el-menu class="aside" router :default-active="$route.path" :default-openeds="openeds" unique-opened="true">
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
      <template slot="title"><i class="el-icon-menu"></i>岗位管理</template>
      <el-menu-item-group>
        <el-menu-item index="/gwBuild">新建岗位</el-menu-item>
        <el-menu-item index="/gwList">岗位列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <el-submenu index="3">
      <template slot="title"><i class="el-icon-menu"></i>员工管理</template>
      <el-menu-item-group>
        <el-menu-item index="/ygBuild">新建员工</el-menu-item>
        <el-menu-item index="/ygList">员工列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <el-submenu index="4">
      <template slot="title"><i class="el-icon-menu"></i>试用管理</template>
      <el-menu-item-group>
        <el-menu-item index="/syBuild">新建试用</el-menu-item>
        <el-menu-item index="/syList">试用列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <el-submenu index="5">
      <template slot="title"><i class="el-icon-menu"></i>离职管理</template>
      <el-menu-item-group>
        <el-menu-item index="/lzBuild">新建离职</el-menu-item>
        <el-menu-item index="/lzList">离职列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>


    <el-submenu  index="6">
      <template slot="title"><i class="el-icon-s-tools"></i>账户管理</template>
      <el-menu-item-group>
        <el-menu-item index="/changePassword">修改密码</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <!-- 仅在 glylx 为 2 时显示修改密码菜单 -->
    <el-submenu v-if="glylx === '2'" index="7">
      <template slot="title"><i class="el-icon-menu"></i>管理员管理</template>
      <el-menu-item-group>
        <el-menu-item index="/glyBuild">新建管理员</el-menu-item>
        <el-menu-item index="/glyList">管理员列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: 'aside',
  data () {
    return {
      openeds: [],
      glylx: '' // 用于保存管理员类型
    };
  },
  created() {
    // 获取管理员类型（可以从 cookie 或 API 获取）
    this.glylx = this.$cookie.get('glylx');
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
