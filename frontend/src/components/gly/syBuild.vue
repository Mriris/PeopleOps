<template>
  <div class="syBuild">
    <div class="adminTitle">
      <span>新建试用</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
      <el-form ref="form" label-position="left" label-width="130px" :model="detailData">
        <el-form-item label="员工编号">
          <el-input v-model="detailData.bh"/>
        </el-form-item>
        <el-form-item label="状　　态">
          <el-select v-model="detailData.zt" placeholder="请选择">
            <el-option v-for="item in ztList" :key="item.id" :label="item.mc" :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="开始日期">
          <el-date-picker v-model="detailData.ksrq" type="date" value-format="yyyy-MM-dd" placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期">
          <el-date-picker v-model="detailData.jsrq" type="date" value-format="yyyy-MM-dd" placeholder="选择日期"></el-date-picker>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'syBuild',
  data () {
    return {
      detailData: {
        bh: '', // 编号
        zt: '', // 状态
        ksrq: '', // 试用开始日期
        jsrq: '', // 试用结束日期
      },
      ztList: [{
          id: '1',
          mc: '正常'
        }, {
          id: '2',
          mc: '延期'
        }, {
          id: '3',
          mc: '结束'
        }, {
          id: '4',
          mc: '不录用'
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
      // formData.append('xm', this.detailData.xm);
      formData.append('zt', this.detailData.zt);
      formData.append('ksrq', this.detailData.ksrq);
      formData.append('jsrq', this.detailData.jsrq);
      this.axios.post('/backend/syBuild', formData).then(response => {
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
          this.$router.push('/syList');
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
      this.$alert('该员工编号已经存在', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>
<style lang="less" scoped>
.syBuild {
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
