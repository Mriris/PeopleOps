<template>
  <div class="bmList">
    <div class="adminTitle">
      <span>员工列表</span>
    </div>
    <div class="tablePage">
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="bh" label="编号" align="center" width="100"></el-table-column>
        <el-table-column prop="mc" label="名称" align="center" width="100"></el-table-column>
        <el-table-column prop="dh" label="电话" align="center" width="100"></el-table-column>
        <el-table-column prop="cz" label="传真" align="center" width="100"></el-table-column>
        <el-table-column prop="clrq" label="成立日期" align="center" width="200"></el-table-column>
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
  name: 'bmList',
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
      this.total = 6; // 表示总的数据条数是6
      if (this.currentPage == 1) {
        this.tableData = [
          {id:'2222cc4e882f4cf692a393890aeed28b',bh:'BM02',mc:'人事行政部',dh:'88880002',cz:'66660002',clrq:'2020-01-01'},
        ]
      } else {
        this.tableData = [
          {id:'3333cc4e882f4cf692a393890aeed28c',bh:'BM03',mc:'财务部',dh:'88880003',cz:'66660003',clrq:'2020-01-01'},
        ];
      }
    },
    handleView (id) {
      this.$router.push({ name: 'bmDetail', params: { id: id } }); // 跳转到员工详细页面
    },
    handleCurrentChange (val) {
      this.currentPage = val;
      this.getTableData();
    }
  }
};
</script>
<style lang="less" scoped>
.bmList {
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
