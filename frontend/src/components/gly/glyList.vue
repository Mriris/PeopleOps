<template>
  <div class="glyList">
    <div class="adminTitle">
      <span>管理员列表</span>
    </div>
    <div class="tablePage">
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="zhm" label="账户名" align="center"></el-table-column>

        <!-- 密码列，支持点击图标切换显示 -->
        <el-table-column label="密码" align="center">
          <template slot-scope="scope">
            <span>{{ scope.row.showPassword ? scope.row.mm : '******' }}</span>
            <el-button type="text" @click="togglePassword(scope.row)">
              <img v-if="!scope.row.showPassword" src="../../img/view.png"  style="width: 20px; height: 20px;" />
<!--              <el-icon class="icon" v-if="!scope.row.showPassword">-->
<!--                <view/>-->
<!--              </el-icon>-->
              <img v-else="!scope.row.showPassword" src="../../img/viewoff.png"  style="width: 20px; height: 20px;" />
            </el-button>
          </template>
        </el-table-column>

        <el-table-column prop="nc" label="昵称" align="center"></el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleView(scope.row.id)">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        class="pageCss"
        background
        :page-size="pageSize"
        :total="total"
        :current-page="currentPage"
        @current-change="handleCurrentChange"
        layout="total, prev, pager, next">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: 'glyList',
  data() {
    return {
      total: 0,
      currentPage: 1,
      pageSize: 5,
      tableData: []
    };
  },
  mounted() {
    this.getTableData();
  },
  methods: {
    getTableData() {
      const formData = new FormData();
      formData.append('page', this.currentPage);
      formData.append('pageSize', this.pageSize);
      this.axios.post('/backend/glyList', formData).then(response => {
        this.total = response.data.total;
        this.tableData = response.data.list.map(item => ({
          ...item,
          showPassword: false // 增加控制密码显示的字段
        }));
      });
    },
    togglePassword(row) {
      row.showPassword = !row.showPassword; // 切换密码的显示状态
    },
    handleView(id) {
      this.$router.push({name: 'glyDetail', params: {id: id}}); // 跳转到详细页面
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getTableData(); // 更新当前页数据
    }
  }
};
</script>

<style lang="less" scoped>
.glyList {
  width: 100%;
  height: 100%;
  background: #fff;

  .tablePage {
    .pageCss {
      margin-top: 15px;
    }
  }

  .icon {
    font-size: 16px; /* 图标大小 */
    color: #409eff; /* 确保图标可见 */
  }
}
</style>
