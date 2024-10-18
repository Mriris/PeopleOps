<template>
  <div class="bmDetail">
    <div class="adminTitle">
      <span>部门详细信息</span>
      <el-button size="mini" type="primary" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="danger" class="buildButton" @click="handleDelete">删除</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="handleUpdate">编辑</el-button>
    </div>
    <div class="detailPage">
      <el-descriptions :border="true" :column="1" :label-style="LS">
        <el-descriptions-item label="编　　号">{{detailData.bh}}</el-descriptions-item>
        <el-descriptions-item label="名　　称">{{detailData.mc}}</el-descriptions-item>
        <el-descriptions-item label="电　　话">{{detailData.dh}}</el-descriptions-item>
        <el-descriptions-item label="传　　真">{{detailData.cz}}</el-descriptions-item>
        <el-descriptions-item label="成立日期">{{detailData.clrq}}</el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>
<script>
export default {
  name: 'bmDetail',
  data () {
    return {
      id: null, // 定义id
      detailData: {
        bh: '', // 编号
        mc: '', // 名称
        dh: '', // 电话
        cz: '', // 传真
        clrq: '', // 成立日期
      },
      LS : {
        'width': '130px',
        'text-align': 'center'
      }
    }
  },
  mounted () {
    this.id = this.$route.params.id; // 获得上个页面传来的id的值
    this.getDetailData();
  },
  methods: {
    getDetailData () {
      // 调用后端接口， 把id作为参数传给后端，后端从数据库中取数据，然后返回给前端
      // this.detailData = {
      //   bh: 'BM01', // 编号
      //   mc: '董事长办公室', // 名称
      //   dh: '88880001', // 电话
      //   cz: '66660001', // 传真
      //   clrq: '2020-01-01', // 成立日期
      // }
      const formData = new FormData();
      formData.append('id', this.id);
      this.axios.post('/backend/bmDetail', formData).then(response => {
        this.detailData = response.data;
      });
    },
    tableBack () {
      this.detailData = {};
      this.$router.push('/bmList');
    },
    handleDelete () {
      this.$confirm('此操作将删除该部门, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // 当点击确定时，执行下面
        const formData = new FormData();
        formData.append('id', this.id);
        this.axios.post(`/backend/bmDelete`,formData).then(response => {
          let res = response.data.res;
          if (res == 1) {
            this.handleSuccess();
          } else {
            this.handleFailure();
          }
        }).catch(error => {
          console.error(error);
          this.$message({
            type: 'error',
            message: '删除失败，请稍后重试'
          });
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
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
        callback: action => {
          this.getTableData();
        }
      });
    },
    handleUpdate () {
      this.$router.push({ name: 'bmUpdate', params: { id: this.id } });
    }
  }
};
</script>
<style lang="less" scoped>
.bmDetail {
  width: 100%;
  height: 100%;
  background: #fff;
}
</style>
