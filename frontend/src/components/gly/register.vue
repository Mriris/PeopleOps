<template>
  <div class="register">
    <div class="formBox">
      <el-form ref="registerData" label-position="left" label-width="130px" :rules="rules" :model="registerData">
        <el-form-item label="账 户 名" prop="zhm">
          <el-input v-model="registerData.zhm"></el-input>
        </el-form-item>
        <el-form-item label="密　　码" prop="mm">
          <el-input v-model="registerData.mm" type="password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="qrmm">
          <el-input v-model="registerData.qrmm" type="password"></el-input>
        </el-form-item>
        <el-form-item label="昵　　称" prop="nc">
          <el-input v-model="registerData.nc"></el-input>
        </el-form-item>
      </el-form>
      <el-button class="formButton" @click="formCancel">取消注册</el-button>
      <el-button type="primary" class="formButton" @click="formSubmit">确认注册</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      registerData: {
        zhm: '', // 账户名
        mm: '', // 密码
        qrmm: '', // 确认密码
        nc: '' // 昵称
      },
      rules: {
        zhm: [{ required: true, message: '请输入账户名', trigger: 'blur' }],
        mm: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        qrmm: [
          {
            required: true,
            validator: (rule, value, callback) => {
              if (!this.registerData.qrmm) {
                callback(new Error('请再次输入密码'));
              } else if (this.registerData.qrmm !== this.registerData.mm) {
                callback(new Error('两次输入的密码不一致'));
              } else {
                callback();
              }
            },
            trigger: 'blur'
          }
        ],
        nc: [{ required: true, message: '请输入昵称', trigger: 'blur' }]
      }
    };
  },
  methods: {
    formSubmit() {
      this.$refs.registerData.validate((valid) => {
        if (valid) {
          this.$http.post('/backend/register', this.registerData).then((response) => {
            const res = response.data;
            if (res.success) {
              this.handleSuccess();
            } else {
              this.handleFailure(res.message);
            }
          });
        }
      });
    },
    formCancel() {
      this.$router.push('/login'); // 跳转到登录页面
    },
    handleSuccess() {
      this.$alert('注册成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: (action) => {
          this.$router.push('/login'); // 注册成功后跳转到登录页面
        }
      });
    },
    handleFailure(message) {
      this.$alert(message, '提示', {
        type: 'error',
        confirmButtonText: '确定'
      });
    }
  }
};
</script>

<style lang="less" scoped>
.register {
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
