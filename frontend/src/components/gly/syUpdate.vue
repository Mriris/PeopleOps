<template>
  <div class="syUpdate">
    <div class="adminTitle">
      <span>试用编辑</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
      <el-form ref="form" label-position="left" label-width="130px" :model="detailData">
        <el-form-item label="员工编号">
          <el-input v-model="detailData.bh"></el-input>
        </el-form-item>
        <el-form-item label="姓　　名">
          <el-input v-model="detailData.xm"></el-input>
        </el-form-item>
        <el-form-item label="状　　态">
          <el-select v-model="detailData.gw" placeholder="请选择">
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
  name: 'syUpdate',
  data () {
    return {
      id: null,
      detailData: {
        bh: '', // 编号
        xm: '', // 姓名
        xt: '', // 状态
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
  mounted () {
    this.id = this.$route.params.id; // 获得上个页面传来的id的值
    this.getDetailData();
  },
  methods: {
    getDetailData () {
      // 调用后端接口，查询员工详细信息
      // this.detailData = {
      //   bh: 'sy0001',
      //   xm: '刘备',
      //   xb: '1',
      //   rzrq: '2021-01-01',
      //   bm: 'b50fb65031644b36ab930928c2984f61',
      //   gw: 'afb5487739e6421a8ed4816837428dd1'
      // };
      const formData = new FormData();
      formData.append('id', this.id);
      this.axios.post('/backend/syDetail', formData).then(response => {
        this.detailData = response.data;
      });
    },
    tableBack () {
      this.detailData = {};
      this.$router.push({ name: 'syDetail', params: { id: this.id } }); // 跳转到员工详细页面
    },
    submit () {
      // 调用后端接口，把数据提交到后端
      // 后端接口返回结果
      let res = 1;
      if (res == 1) {
        this.handleSuccess();
      } else if (res == -1) {
        this.handleFailureBhExist();
      } else {
        this.handleFailure();
      }
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
.syUpdate {
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