﻿<template>
  <div class="lzBuild">
    <div class="adminTitle">
      <span>新建离职</span>
      <el-button size="mini" class="buildButton" @click="tableBack">返回</el-button>
      <el-button size="mini" type="success" class="buildButton" @click="submit">提交</el-button>
    </div>
    <div class="detailPage">
      <el-form ref="form" label-position="left" label-width="130px" :model="detailData">
        <el-form-item label="员工编号">
          <el-input v-model="detailData.ygid"></el-input>
        </el-form-item>
        <el-form-item label="离职日期">
          <el-date-picker v-model="detailData.lzrq" type="date" value-format="yyyy-MM-dd" placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="离职类型">
          <el-select v-model="detailData.lzlx" placeholder="请选择">
            <el-option v-for="item in lzlxList" :key="item.id" :label="item.mc" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'lzBuild',
  data () {
    return {
      detailData: {
        ygid: '', // 编号
        lzrq: '', // 入职日期
        lzlx: '', // 离职类型
      },
      lzlxList: [{
          id: '1',
          mc: '主动辞退'
        }, {
          id: '2',
          mc: '辞退'
        }, {
          id: '3',
          mc: '退休'
        }, {
          id: '4',
          mc: '开除'
        }, {
          id: '5',
          mc: '试用期未通过'
        }]
    }
  },
  methods: {
    tableBack () {
      this.detailData = {};
      this.$router.push('/welcome');
    },
    submit() {
      // 调用后端接口，把数据提交到后端
      const formData = new FormData();
      formData.append('ygid', this.detailData.ygid);
      formData.append('lzrq', this.detailData.lzrq);
      formData.append('lzlx', this.detailData.lzlx);

      console.log(this.detailData.lzrq);
      console.log(this.detailData.lzlx);

      this.axios.post('/backend/lzInsert', formData)
        .then(response => {
          // 后端接口返回结果
          let res = response.data.res;
          let msg = response.data.message;
          if (res == 1) {
            this.handleSuccess();
          } else if (res == -1) {
            this.handleFailureBhExist();
          }else if (res == 0){
            this.handleFailureBhNonExist()
          }
          else {
            this.handleFailure();
            alert("无法创建"); // 显示“无法创建”信息
          }
        })
        .catch(error => {
          console.error("提交失败:", error);
          alert("无法创建"); // 显示“无法创建”信息
        });
    },
    handleSuccess () {
      this.$alert('操作成功', '提示', {
        type: 'success',
        confirmButtonText: '确定',
        callback: action => {
          this.$router.push('/lzList');
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
    },
    handleFailureBhNonExist () {
      this.$alert('该员工编号不存在', '提示', {
        type: 'error',
        confirmButtonText: '确定',
        callback: action => {}
      });
    }
  }
};
</script>
<style lang="less" scoped>
.lzBuild {
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
