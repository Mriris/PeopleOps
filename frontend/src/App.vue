<template>
  <div id="app">
    <router-view />
  </div>
</template>
<script>
export default {
  name: 'App'
};
</script>
<style lang="less">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  font-family: cursive;
  /* color: #2fa54a; */
  height: 100%;
}
h1 {
  font-size: 40px;
}
html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  min-width: 1100px;
  min-height: 550px;
  /* max-width: 1920px; */
  transform-origin: 0 0 0; /* 指定缩放的基本点 */
  -moz-transform-origin: 0 0 0;
  -ms-transform-origin: 0 0 0;
  -webkit-transform-origin: 0 0 0;
  -o-transform-origin: 0 0 0;
  /* background: #f2f2f2; */
  /* overflow: hidden; */
}
.mainBg {
  .adminTitle {
    text-align: left;
    color: #409eff;
    font-size: 23px;
    font-weight: bolder;
    /* 右上按钮位置 */
    .buildButton {
      float: right;
      margin-right: 1%;
    }
  }
  /* 详情表单位置 */
  .detailPage {
    margin: 2% 20% 2% 20%;
  }
}
.el-container {
  height: 100%;
}
.contentTitleTop {
  font-size: 20px;
  padding: 2% 15% 0;
  text-align: left;
  .el-divider {
    background-color: #2fa54a;
    height: 0.5px;
  }
}
.selectInput {
  width: 21%;
  float: right;
  margin-top: -8px;
  .el-input__inner {
    border-radius: 25px;
    height: 35px;
  }
  .el-input__inner:focus {
    border-color: #2fa54a;
  }
  .el-input__suffix {
    top: -1px;
  }
}
.contentSelect {
  float: right;
  margin-top: 8px;
}
.contentSelect:hover {
  cursor: pointer;
  color: #2fa54a;
}
.leftList {
  .el-submenu {
    text-align: left;
  }
  .el-menu-item {
    text-align: center;
  }
}
/* 分页设置 */
.block {
  margin: 0;
  .el-pagination {
    text-align: center;
  }
  .el-dialog,
  .el-pager li {
    background: unset;
  }
  .el-pager li.active {
    color: #2fa54a;
  }
  .el-pager li:hover {
    color: #2fa54a;
  }
  .el-pagination .btn-next,
  .el-pagination .btn-prev {
    background: unset;
  }
  .el-pagination button:disabled {
    background-color: unset;
  }
  .el-pagination button:hover {
    color: #2fa54a;
  }
}
/* 详情页顶部标题样式 */
.detillTitleCss {
  /* margin-top: 0; */
  /* margin-bottom: 1%; */
  margin-top: -30px;
  margin-bottom: 0%;
  font-size: 2vw;
  color: #2fa54a;
  /* background: #ffffff80; */
  line-height: 5vw;
}
/* 详情页下部介绍样式 */
.detillBottomBox {
  padding: 4% 0;
  border: 1px solid #90939959;
  border-top: 0px;
  background: #ffffff80;
  .bottomOther {
    padding: 2% 10%;
    font-size: 1.5vw;
  }
  /* 标签页样式自适应 */
  .el-tabs__nav {
    margin-left: 5%;
    border: 1px solid #67c23a;
    margin-bottom: -1px;
  }
  .el-tabs__item {
    padding: 0 2vw;
    height: 3vw;
    font-size: 1.2vw;
    line-height: 3vw;
    border-bottom: 0px;
  }
  .el-tabs__item:hover {
    color: #67c23a;
  }
  .el-tabs__item.is-active {
    color: #fff;
    background: #67c23a;
  }
  .el-tabs--card > .el-tabs__header {
    border-bottom: 0.5vw solid #67c23a;
  }
  /* 标签页样式自适应 */
}
/* 管理员详情页图片样式 */
.detailPage {
  .el-date-editor.el-input,
  .el-date-editor.el-input__inner {
    width: 100%;
  }
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
    width: 230px;
    height: 230px;
    line-height: 230px;
    text-align: center;
  }
  .avatar {
    width: 230px;
    height: 230px;
    display: block;
  }
}
</style>