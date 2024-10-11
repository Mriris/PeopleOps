<template>
  <div class="lzList">
    <div class="adminTitle">
      <span>离职列表</span>
    </div>
    <div class="tablePage">
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="bh" label="员工编号" align="center" ></el-table-column>
        <el-table-column prop="xm" label="姓名" align="center" ></el-table-column>
        <el-table-column prop="lzrq" label="离职日期" align="center" ></el-table-column>
        <el-table-column prop="lzlx" label="离职类型" align="center" ></el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleView(scope.row.id)">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination class="pageCss" background :page-size="pageSize" :total="total" :current-page="currentPage" @current-change="handleCurrentChange" layout="total, prev, pager, next"></el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  name: 'lzList',
  data () {
    return {
      total: 0, // 查询数据库时全部的条数
      currentPage: 1, // 当前显示第几页
      pageSize: 5, // 每页显示的条数
      tableData: [] // 表格里要显示的数据，类型是数组
    }
  },
  mounted () {
    this.getTableData();
  },
  methods: {
    getTableData () {
      // 调用后端接口，从数据库中取出员工列表
      const formData = new FormData();
      formData.append('page', this.currentPage);
      formData.append('pageSize', this.pageSize);
      this.axios.post('/backend/lzList', formData).then(response => {
        this.total = response.data.total;
        this.tableData = response.data.list;
      });
      // this.total = 6; // 表示总的数据条数是6
      // if (this.currentPage == 1) {
      //   this.tableData = [
      //     {id:'e235cc4e882f4cf692a393890aeed28b',bh:'lz0001',xm:'刘备',xb:'男',rzrq:'2021-01-01',bm:'总经理办公室',gw:'总经理'},
      //     {id:'3ec0d5c612fa46da963c62cd21a53097',bh:'lz0002',xm:'关羽',xb:'男',rzrq:'2021-01-01',bm:'人事行政部',gw:'人事行政经理'},
      //     {id:'5c9d48960136440b97e518377d9b7e0f',bh:'lz0003',xm:'张飞',xb:'男',rzrq:'2021-01-01',bm:'人事行政部',gw:'人事主管'}
      //   ]
      // } else {
      //   this.tableData = [
      //     {id:'0ba6b693d1fd4fd1a9223645c48c61ed',bh:'lz0004',xm:'马超',xb:'男',rzrq:'2021-01-01',bm:'人事行政部',gw:'人事专员'},
      //     {id:'d8238c31965f4ced9c827e55cd0d8bf0',bh:'lz0005',xm:'廖化',xb:'男',rzrq:'2021-01-01',bm:'人事行政部',gw:'人事专员'},
      //     {id:'836f5e22ca7d4e2294abbacfaf2f789e',bh:'lz0006',xm:'魏延',xb:'男',rzrq:'2021-01-01',bm:'人事行政部',gw:'人事专员'}
      //   ];
      // }
    },
    handleView (id) {
      this.$router.push({ name: 'lzDetail', params: { id: id } }); // 跳转到员工详细页面
    },
    handleCurrentChange (val) {
      this.currentPage = val;
      this.getTableData();
    }
  }
};
</script>
<style lang="less" scoped>
.lzList {
  width: 100%;
  height: 100%;
  background: #fff;
  .tablePage {
    .pageCss {
      margin-top: 15px;
    }
  }
  .detailPage {
    .avatar-uploader .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
      border-color: #409eff;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 150px;
      height: 150px;
      line-height: 150px;
      text-align: center;
    }
    .avatar {
      width: 150px;
      height: 150px;
      display: block;
    }
  }
}
</style>
