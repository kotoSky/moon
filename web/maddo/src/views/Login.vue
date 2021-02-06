<template>
  <body id="poster">
  <el-form class="login-container" label-position="left"
           ref="loginFromRef" :model="loginForm" :rules="loginFormRules"
           label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>

import {getCurrentInstance, inject, reactive, toRefs} from "vue";

export default {
  name: "Login",
  setup() {
    //获取页面实例
    const instance = getCurrentInstance();
    // 注入axios
    const axios = inject('axios');
    // reactive设置为反应性数据
    const data = reactive({
      // 登录表达数据绑定对象
      loginForm: {
        username: 'admin',
        password: '123'
      },
      // 表单验证规则
      loginFormRules: {
        // 验证用户名是否合法
        username: [
          {required: true, message: "请输入用户名", trigger: "blur"},
          {min: 3, max: 10, message: "长度在3到10个字符", trigger: "blur"},
        ],
        // 验证密码是否合法
        password: [
          {required: true, message: "请输入密码", trigger: "blur"},
          {min: 6, max: 15, message: "长度在6到15个字符", trigger: "blur"},
        ],
      }
    });

    //表单重置
    const resetLoginForm = () => {
      console.log(instance);
      instance.refs.loginFromRef.resetFields();
    };
    
    // 登录方法
    const login = () => {
      instance.refs.loginFromRef.validate((valid) => {
        
        if (!valid) return;

        axios.request({
          url: '/login',
          method: 'post',
          data: instance.ctx.loginForm
        }).then(res => {
          alert(res.code);
        })
        
      })
      
    };

    const refData = toRefs(data);

    return {
      ...refData,
      resetLoginForm,
      login
    }

  }
}
</script>

<style scoped>

#poster {
  background: url("../assets/images/loginback.png") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0px;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

</style>