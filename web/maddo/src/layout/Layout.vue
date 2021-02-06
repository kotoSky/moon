<template>
  <el-container style="height: 100%; border: 0px solid #eee">
    <!-- 侧边栏菜单 -->
    <el-aside>
      <el-menu
          :uniqueOpened="true"
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-submenu index="1">
          <template #title>
            <i class="el-icon-location"></i>
            <span>导航一</span>
          </template>
          <el-menu-item-group>
            <template #title>分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template #title>选项4</template>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <template #title>导航二</template>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <i class="el-icon-document"></i>
          <template #title>导航三</template>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <template #title>导航四</template>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <!-- 顶部和显示区域 -->
    <el-container>

      <el-header>
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>

      

    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "layout",
  setup() {
    const item = {
      date: '2021-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(10).fill(item)
    }
  }
}
</script>

<style scoped>
.el-container {
  position: absolute;
  width: 100%;
  top: 0px;
  left: 0;
  bottom: 0;
}

.el-header {
  padding: 0;
  z-index: 1000;
}

.el-header .fr {
  float: right;
}

.el-header .el-menu {
  border-bottom: none;
}

.el-aside, .el-main {
  padding-top: 60px;
}

.el-aside {
  background: #545c64;
}

.el-aside .el-menu {
  border-right: none;
}

</style>