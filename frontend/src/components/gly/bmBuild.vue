<template>
  <div class="bmBuild">
    <div class="adminTitle">
      <span>新建部门</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
      <el-form ref="form" label-position="left" label-width="130px" :model="detailData">
        <el-form-item label="编　　号">
          <el-input v-model="detailData.bh"></el-input>
        </el-form-item>
        <el-form-item label="名　　称">
          <el-input v-model="detailData.mc"></el-input>
        </el-form-item>
        <el-form-item label="电　　话">
          <el-input v-model="detailData.dh"></el-input>
        </el-form-item>
        <el-form-item label="传　　真">
          <el-input v-model="detailData.cz"></el-input>
        </el-form-item>
        <el-form-item label="成立日期">
          <el-date-picker v-model="detailData.clrq" type="date" value-format="yyyy-MM-dd" placeholder="选择日期"></el-date-picker>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'bmBuild',
  data () {
    return {
      detailData: {
        bh: '', // 编号
        mc: '', // 名称
        dh: '', // 电话
        cz: '', // 传真
        clrq: '', // 成立日期
      },
      bmList: [{
          id: 'b50fb65031644b36ab930928c2984f61',
          mc: '总经理办公室'
        }, {
          id: '7b08eb003c474147a7d762ad5fb15246',
          mc: '人事行政部'
        }, {
          id: '880fc4a8a7374ce99ade9b0f38477bd6',
          mc: '财务部'
        }, {
          id: '4150aa673b2c4c0abd23b337cb01b874',
          mc: '法务部'
        }, {
          id: 'a1cb99d12dd34906ac2500f86b015b2b',
          mc: '产品技术部'
        }],
      gwList: [{
          id: 'e163b9964b154e7e94baa3743a7ca60f',
          mc: '总经理'
        }, {
          id: 'afb5487739e6421a8ed4816837428dd1',
          mc: '总经理助理'
        }, {
          id: '2a356d766c114505857a9351bb318ed3',
          mc: '人事行政经理'
        }, {
          id: '323ff2f7164247288fe8e4955eb47c86',
          mc: '人事主管'
        }, {
          id: '8f1797eec70d42b3b0781fd83905f3a6',
          mc: '人事专员'
        }]
    }
  },
  methods: {
    tableBack () {
      this.detailData = {};
      this.$router.push('/welcome');
    },
    submit () {
      const formData = new FormData();
      // formData.append('id', this.id);
      formData.append('bh', this.detailData.bh);
      formData.append('mc', this.detailData.mc);
      formData.append('dh', this.detailData.dh);
      formData.append('cz', this.detailData.cz);
      formData.append('clrq', this.detailData.clrq);
      this.axios.post('/backend/bmBuild', formData).then(response => {
        // this.detailData = response.data;
        // 后端接口返回结果
        let res = response.data.res;
        if (res == 1) {
          this.handleSuccess();
        } else if (res == -1) {
          this.handleFailureBhExist();
        } else {
          this.handleFailure();
        }
      });
    },
    handleSuccess () {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.$router.push('/bmList');
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
    handleFailureBhExist () {
      this.$alert('该部门编号已经存在', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>
<style lang="less" scoped>
.bmBuild {
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
