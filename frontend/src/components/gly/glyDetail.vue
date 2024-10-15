<template>
  <div class="glyDetail">
    <div class="adminTitle">
      <span>管理员详细信息</span>
      <el-button size="mini" type="primary" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="danger" class="buildButton" @click="handleDelete">删除</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="handleUpdate">编辑</el-button>
    </div>
    <div class="detailPage">
      <el-descriptions :border="true" :column="1" :label-style="LS">
        <el-descriptions-item label="账 户 名">{{ detailData.zhm }}</el-descriptions-item>
        <el-descriptions-item label="密　　码">{{ detailData.mm }}</el-descriptions-item>
        <el-descriptions-item label="昵　　称">{{ detailData.nc }}</el-descriptions-item>
        <el-descriptions-item label="类　　型">{{ detailData.glylx }}</el-descriptions-item>

      </el-descriptions>
    </div>
  </div>
</template>
<script>
export default {
  name: 'glyDetail',
  data() {
    return {
      id: null, // 定义id
      detailData: {
        zhm: '', // 编号
        mm: '', // 姓名
        nc: '', // 性别
        glclx: ''
      },
      LS: {
        'width': '130px',
        'text-align': 'center'
      }
    }
  },
  mounted() {
    this.id = this.$route.params.id; // 获得上个页面传来的id的值
    this.getDetailData();
  },
  methods: {
    getDetailData() {
      // 调用后端接口， 把id作为参数传给后端，后端从数据库中取数据，然后返回给前端
      const formData = new FormData();
      formData.append('id', this.id);
      this.axios.post('/backend/glyDetail', formData).then(response => {
        this.detailData = response.data;
      });
      // this.detailData = {
      //   bh: 'gly0001',
      //   xm: '刘备',
      //   xb: '男',
      //   rzrq: '2021-01-01',
      //   bm: '总经理办公室',
      //   gw: '总经理',
      //   csrq: '2000-01-02'
      // }
    },
    tableBack() {
      // this.detailData = {};
      this.$router.push('/glyList');
    },
    handleDelete() {
      this.$confirm('此操作将删除该员工, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 使用 axios.delete 发送 DELETE 请求
        this.axios.delete(`/backend/glyDelete?id=${this.id}`).then(response => {
          let res = response.data.success; // 修改为获取正确的返回结果
          if (res) {
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
    handleSuccess() {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.$router.push('/glyList');
        }
      });
    },
    handleFailure() {
      this.$alert('操作失败', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {
          this.getTableData();
        }
      });
    },
    handleUpdate() {
      this.$router.push({name: 'glyUpdate', params: {id: this.id}});
      console.log(id);
    }
  }
};
</script>
<style lang="less" scoped>
.glyDetail {
  width: 100%;
  height: 100%;
  background: #fff;
}
</style>
