<template>
  <div class="ygDetail">
    <div class="adminTitle">
      <span>员工详细信息</span>
      <el-button size="mini" type="primary" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="danger" class="buildButton" @click="handleDelete">删除</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="handleUpdate">编辑</el-button>
    </div>
    <div class="detailPage">
      <el-descriptions :border="true" :column="1" :label-style="LS">
        <el-descriptions-item label="编　　号">{{ detailData.bh }}</el-descriptions-item>
        <el-descriptions-item label="姓　　名">{{ detailData.xm }}</el-descriptions-item>
        <el-descriptions-item label="性　　别">{{ detailData.xb }}</el-descriptions-item>
        <el-descriptions-item label="入职日期">{{ detailData.rzrq }}</el-descriptions-item>
        <el-descriptions-item label="部　　门">{{ detailData.bm }}</el-descriptions-item>
        <el-descriptions-item label="岗　　位">{{ detailData.gw }}</el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>
<script>
export default {
  name: 'ygDetail',
  data() {
    return {
      id: null, // 定义id
      detailData: {
        bh: '', // 编号
        xm: '', // 姓名
        xb: '', // 性别
        rzrq: '', // 入职日期
        bm: '', // 部门
        gw: '' // 岗位
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
      this.axios.post('/backend/ygDetail', formData).then(response => {
        this.detailData = response.data;
      });
      // this.detailData = {
      //   bh: 'YG0001',
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
      this.$router.push('/ygList');
    },
    handleDelete() {
      this.$confirm('此操作将删除该员工, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // 当点击确定时，执行下面
        // 调用后端接口
        // 后端接口返回结果
        let res = 1;
        if (res == 1) { // 表示删除了一条数据，也就是操作成功了
          this.handleSuccess();
        } else {
          this.handleFailure();
        }
      });
    },
    handleSuccess() {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.$router.push('/ygList');
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
      this.$router.push({name: 'ygUpdate', params: {id: this.id}});
    }
  }
};
</script>
<style lang="less" scoped>
.ygDetail {
  width: 100%;
  height: 100%;
  background: #fff;
}
</style>
