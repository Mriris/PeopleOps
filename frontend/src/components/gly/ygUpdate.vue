<template>
  <div class="ygUpdate">
    <div class="adminTitle">
      <span>编辑员工</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
      <el-form ref="form" label-position="left" label-width="130px" :model="detailData">
        <el-form-item label="编　　号">
          <el-input v-model="detailData.bh"></el-input>
        </el-form-item>
        <el-form-item label="姓　　名">
          <el-input v-model="detailData.xm"></el-input>
        </el-form-item>
        <el-form-item label="性　　别">
          <el-radio v-model="detailData.xb" label="1">男</el-radio>
          <el-radio v-model="detailData.xb" label="2">女</el-radio>
        </el-form-item>
        <el-form-item label="入职日期">
          <el-date-picker v-model="detailData.rzrq" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="部　　门">
          <el-select v-model="detailData.bm" placeholder="请选择">
            <el-option v-for="item in bmList" :key="item.id" :label="item.mc" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="岗　　位">
          <el-select v-model="detailData.gw" placeholder="请选择">
            <el-option v-for="item in gwList" :key="item.id" :label="item.mc" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'ygUpdate',
  data () {
    return {
      id: null,
      detailData: {
        // id: '', // 编号
        bh: '', // 编号
        xm: '', // 姓名
        xb: '', // 性别
        csrq: '', // 入职日期
        rzrq: '', // 入职日期
        bm: '', // 部门
        gw: '' // 岗位
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
  mounted () {
    this.id = this.$route.params.id; // 获得上个页面传来的id的值
    this.getDetailData();
  },
  methods: {
    getDetailData () {
      // 调用后端接口，查询员工详细信息
      // this.detailData = {
      //   bh: 'YG0001',
      //   xm: '刘备',
      //   xb: '1',
      //   rzrq: '2021-01-01',
      //   bm: 'b50fb65031644b36ab930928c2984f61',
      //   gw: 'afb5487739e6421a8ed4816837428dd1'
      // };
      const formData = new FormData();
      formData.append('id', this.id);
      this.axios.post('/backend/ygDetail', formData).then(response => {
        this.detailData = response.data;
      });
    },
    tableBack () {
      // this.detailData = {};
      this.$router.push({ name: 'ygDetail', params: { id: this.id } }); // 跳转到员工详细页面
    },
    submit () {
      // 调用后端接口，把数据提交到后端
      const formData = new FormData();
      formData.append('id', this.id);
      formData.append('bh', this.detailData.bh);
      formData.append('xm', this.detailData.xm);
      formData.append('xb', this.detailData.xb);
      // formData.append('csrq', this.detailData.csrq);
      formData.append('rzrq', this.detailData.rzrq);
      formData.append('bm', this.detailData.bm);
      formData.append('gw', this.detailData.gw);
      this.axios.post('/backend/ygUpdate', formData).then(response => {
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
.ygUpdate {
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
