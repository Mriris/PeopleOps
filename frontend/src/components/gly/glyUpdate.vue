<template>
  <div class="glyUpdate">
    <div class="adminTitle">
      <span>编辑管理员</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
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
    </div>
  </div>
</template>
<script>
export default {
  name: 'glyUpdate',
  data () {
    return {
      id: null,
      registerData: {
        zhm: '', // 账户名
        mm: '', // 密码
        qrmm: '', // 确认密码
        nc: '', // 昵称
        glylx: '1'
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
    }
  },
  mounted () {
    this.id = this.$route.params.id; // 获得上个页面传来的id的值
    this.getDetailData();
  },
  methods: {
    getDetailData () {
      this.axios.get(`/backend/glyDetail?id=${this.id}`).then(response => {
        this.registerData = response.data; // 将获取到的详情数据赋值给 registerData
      });
    },
    tableBack () {
      this.$router.push({ name: 'glyDetail', params: { id: this.id } }); // 跳转到管理员详细页面
    },
    submit() {
      // 调用表单校验
      this.$refs.registerData.validate((valid) => {
        if (valid) {
          const formData = {
            id: this.id,  // 使用当前的管理员ID
            zhm: this.registerData.zhm,
            mm: this.registerData.mm,
            nc: this.registerData.nc
          };

          this.axios.post('/backend/glyUpdate', formData).then(response => {
            let res = response.data.success;
            if (res) {
              this.handleSuccess();
            } else {
              this.handleFailure();
            }
          });
        } else {
          // 如果校验失败
          this.$alert('请检查输入是否正确', '提示', {
            type: 'error',
            confirmButtonText: '确定'
          });
        }
      });
    },
    handleSuccess () {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.tableBack();
        }
      });
    },
    handleFailure () {
      this.$alert('操作失败', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>

<style lang="less" scoped>
.glyUpdate {
  width: 100%;
  height: 100%;
  background: #fff;
  .tablePage {
    .pageCss {
      margin-top: 15px;
    }
  }
  .detailPage {
    .el-date-editor.el-input,
    .el-date-editor.el-input__inner {
      width: 100%;
    }
  }
}
</style>
