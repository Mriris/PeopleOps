<template>
  <div class="changePassword">
    <div class="formBox">
      <el-form ref="adminData" label-position="left" label-width="130px" :rules="rules" :model="adminData">
        <el-form-item label="原 密 码" prop="ymm">
          <el-input v-model="adminData.ymm" type="password"></el-input>
        </el-form-item>
        <el-form-item label="新 密 码" prop="xmm">
          <el-input v-model="adminData.xmm" type="password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="qrmm">
          <el-input v-model="adminData.qrmm" type="password"></el-input>
        </el-form-item>
      </el-form>
      <el-button class="formButton" @click="formCancel">取消修改</el-button>
      <el-button type="primary" class="formButton" @click="formSubmit">确认修改</el-button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'changePassword',
  data () {
    return {
      adminData: {
        ymm: '', // 原密码
        xmm: '', // 新密码
        qrmm: '' // 确认密码
      },
      rules: {
        ymm: [{
          required: true,
          validator: (rule, value, callback) => {
            if (!this.adminData.ymm) {
              callback(new Error("请输入原密码"));
            } else {
              callback();
            }
          },
          trigger: 'blur'
        }],
        xmm: [{
          required: true,
          validator: (rule, value, callback) => {
            if (!this.adminData.xmm) {
              callback(new Error("请输入新密码"));
            } else if (!/^[a-zA-Z0-9_]\w{5,19}$/.test(this.adminData.xmm)) {
              callback(new Error("6-20位字符"));
            } else if (this.adminData.xmm == this.adminData.ymm) {
              callback(new Error("新密码不能与原密码相同"));
            } else {
              callback();
            }
          },
          trigger: 'blur'
        }],
        qrmm: [{
          required: true,
          validator: (rule, value, callback) => {
            if (!this.adminData.qrmm) {
              callback(new Error("请再次输入新密码"));
            } else if (this.adminData.qrmm != this.adminData.xmm) {
              callback(new Error("两次输入的新密码不一致"));
            } else {
              callback();
            }
          },
          trigger: 'blur'
        }],
      }
    }
  },
  methods: {
    formSubmit () {
      this.$refs.adminData.validate((valid) => { // valid表示校验的结果，所有校验都通过时，valid为true
        if (valid) {
          const id = this.$cookie.get('gly_id');
          // 调用后端接口
          let res = 1;
          if (res == 1) {
            this.handleSuccess(); // 提示操作成功
          } else if (res == -1) {
            this.handleFailurePasswordError(); // 提示原密码错误
          } else {
            this.handleFailure(); // 提示操作失败
          }
        }
      });
    },
    formCancel () {
      this.$router.push('/welcome'); // 跳转到欢迎页面
    },
    handleSuccess () {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.$router.push('/welcome'); // 跳转到欢迎页面
        }
      });
    },
    handleFailure () {
      this.$alert('操作失败', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    },
    handleFailurePasswordError () {
      this.$alert('原密码错误', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>
<style lang="less" scoped>
.changePassword {
  width: 100%;
  height: 100%;
  background: #fff;
  .formBox {
    padding: 5% 30% 5% 30%;
    .formButton {
      margin-top: 3%;
      margin-left: 10%;
    }
  }
}
</style>