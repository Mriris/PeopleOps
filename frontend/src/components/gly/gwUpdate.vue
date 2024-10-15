<template>
  <div class="gwUpdate">
    <div class="adminTitle">
      <span>编辑岗位</span>
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
        <el-form-item label="岗位类型">
          <el-select v-model="detailData.gwlx" placeholder="请选择">
            <el-option v-for="item in gwlxList" :key="item.id" :label="item.mc" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'gwUpdate',
  data () {
    return {
      id: null,
      detailData: {
        bh: '', // 编号
        mc: '', // 名称
        gwlx: '', //岗位类型
      },
      gwlxList: [{
          id: '1',
          mc: '经理'
        }, {
          id: '2',
          mc: '主管'
        }, {
          id: '3',
          mc: '专员'
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
      // this.detailData = {id:'2222cc4e882f4cf692a393890aeed28b',bh:'gw02',mc:'人事行政部',dh:'88880002',cz:'66660002',clrq:'2020-01-01'};
      const formData = new FormData();
      formData.append('id', this.id);
      this.axios.post('/backend/gwDetail2', formData).then(response => {
        this.detailData = response.data;
      });
    },
    tableBack () {
      this.detailData = {};
      this.$router.push({ name: 'gwDetail', params: { id: this.id } }); // 跳转到员工详细页面
    },
    submit () {
      const formData = new FormData();
      formData.append('id', this.id);
      formData.append('bh', this.detailData.bh);
      formData.append('mc', this.detailData.mc);
      formData.append('gwlx', this.detailData.gwlx);
      this.axios.post('/backend/gwUpdate', formData).then(response => {
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
      this.$alert('该岗位编号已经存在', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>
<style lang="less" scoped>
.gwUpdate {
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
