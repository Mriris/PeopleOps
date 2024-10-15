<template>
  <div class="login">
    <div class="drag">
      <el-card shadow="always">
        <h2>企业人事管理系统</h2>
        <h2>管理员登录</h2>
        <el-form ref="form" :rules="rules" :model="loginData">
          <el-form-item prop="zhm">
            <el-input v-model="loginData.zhm" placeholder="请输入账户名"></el-input>
          </el-form-item>
          <el-form-item prop="mm">
            <el-input v-model="loginData.mm" placeholder="请输入密码" show-password></el-input>
          </el-form-item>
        </el-form>
        <el-button type="success" class="loginButton" @click="toLogin">登录</el-button>
        <br>
<!--        删除注册按钮-->
<!--        <el-button type="primary" class="registerButton" @click="toRegister">注册</el-button>-->
      </el-card>
    </div>
  </div>
</template>
<script>
export default {
  name: 'login',
  data () {
    return {
      loginData: {
        zhm: '', // 账户名
        mm: '', // 密码
      },
      rules: {
        zhm: [{
          required: true,
          validator: (rule, value, callback) => {
            if (!this.loginData.zhm) {
              callback(new Error("请输入账户名"));
            } else {
              callback();
            }
          },
          trigger: 'change'
        }],
        mm: [{
          required: true,
          validator: (rule, value, callback) => {
            if (!this.loginData.mm) {
              callback(new Error("请输入密码"));
            } else {
              callback();
            }
          },
          trigger: 'change'
        }],
      }
    }
  },
  methods: {
    toLogin() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.$http.post('/backend/login', this.loginData)
            .then(response => {
              const data = response.data;
              if (data.success) {
                console.log("1111111");
                this.$cookie.set('qx', data.qx);
                this.$cookie.set('gly_id', data.gly_id);
                this.$cookie.set('nc', data.nc);
                this.$cookie.set('glylx', data.glylx);
                console.log(data);
                this.$router.push('/welcome');
              } else {
                this.handleFailure();
              }
            })
            .catch(() => {
              this.$message({
                type: 'error',
                message: '服务器错误'
              });
            });
        }
      });
    },
    toRegister(){
      this.$router.push('/register');
    },
    handleFailure () {
      this.$message({
        type: 'error',
        message: '输入的账户名或者密码错误'
      });
    },
  }
};
</script>
<style lang="less" scoped>
.login {
  height: 100%;
  position: relative;
  /* background: url('../../img/bg.png') no-repeat fixed; */
  /* background-color: blue; */
  background-size: 100%;
  padding: 1px;
  box-sizing: border-box;
  z-index: 1;
}
.login:after {
  content: '';
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  /* background: inherit; */
  filter: blur(5px);
  z-index: 2;
}
.drag {
  position: absolute;
  left: 50%;
  top: 45%;
  transform: translate(-50%, -50%);
  width: 30%;
  height: 27vw;
  text-align: center;
  z-index: 11;
  .el-card {
    height: 100%;
    h2 {
      font-size: 1.5vw;
      color: #2fa54a;
    }
    .inputCss {
      margin-bottom: 8%;
    }
    .el-input__inner {
      border-radius: 25px;
      height: 2.8vw;
    }
    .el-input__inner:focus {
      border-color: #2fa54a;
    }
    .el-input__suffix {
      top: -1px;
    }
    .loginButton {
      width: 35%;
      margin-top: 1%;
      font-size: 1vw;
      border-radius: 25px;
    }
    .registerButton {
      width: 35%;
      margin-top: 5%;
      font-size: 1vw;
      border-radius: 25px;
    }
    .loginTypeButton {
      width: 35%;
      /* margin-top: 4%; */
      font-size: 1vw;
      border-radius: 25px;
    }
  }
  .el-card__body {
    padding: 5%;
    height: 86%;
  }
}
</style>
