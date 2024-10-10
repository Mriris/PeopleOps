<template>
  <div class="header">
    <div class="titleLeft">
      <span>企业人事管理系统</span>
    </div>
    <div class="titleRight">
      <span class="clickOut" @click="clickOut"><i class="el-icon-switch-button"></i>安全退出</span>
      <span>{{welcomeName}}</span>
    </div>
  </div>
</template>
<script>
export default {
  name: 'header',
  data () {
    return {
      welcomeName: ''
    }
  },
  created () {
    this.changeCookie();
  },
  methods: {
    changeCookie () {
      const qx = this.$cookie.get('qx');
      if (qx == '1') { // 管理员登录
        this.welcomeName = '欢迎管理员 ' + this.$cookie.get('nc');
      } else {
        this.welcomeName = '';
      }
    },
    clickOut () { // 退出登录
      // 修改登录状态
      this.$cookie.set('qx', '', -1); // 权限
      this.$cookie.set('gly_id', '', -1); // 管理员id
      this.$cookie.set('nc', '', -1); // 昵称

      this.$router.push('/login'); // 返回登录页
    }
  }
};
</script>
<style lang="less" scoped>
.header {
  .titleLeft {
    width: 70%;
    float: left;
    height: 100%;
    text-align: left;
    font-size: 25px;
    font-weight: bolder;
    line-height: 60px;
  }
  .titleRight {
    width: 30%;
    float: right;
    line-height: 60px;
    span {
      padding-right: 15px;
      float: right;
    }
    .clickOut:hover {
      cursor: pointer;
      color: #409eff;
    }
  }
}
</style>