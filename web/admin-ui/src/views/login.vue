<template>
  <div class="container">
    <el-form class="login_container"
             ref="loginFromRef"
             :model="loginForm"
             :rules="loginFormRules"
    >
      <h3 class="login_title">系统登录</h3>
      <el-form-item>
        <el-input type="text" v-model="loginForm.username"
                  auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="loginForm.password"
                  auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button type="primary" style="background: #505458;border: none" @click="submitForm">登录</el-button>
        <el-button style="margin-left: 10px" @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts" setup>

import {reactive, ref, unref} from 'vue'
import {useRouter} from 'vue-router'

// 对密码和邮箱进行类型限制
interface loginData {
  username: string;
  password: string;
}

const loginForm = ref<loginData>({
  username: '',
  password: ''
})

const router = useRouter()
const loginFromRef = ref();

// 自定义验证规则
const validatePass = (rule, value, callback) => {
  //  密码只能由大小写英文字母或数字开头，且由大小写英文字母_.组成
  const reg = /^[A-Za-z0-9][A-Za-z0-9_.]{5,14}$/
  console.log('reg', value.match(reg))
  if (!value.match(reg)) {
    callback(new Error('密码由字母或数字开头，且只能为字母,数字,下划线及（.）'))
  } else {
    callback()
  }
}

// 定义校验规则
const loginFormRules = reactive({
  username: [
    {required: true, message: '用户名不能为空', trigger: 'blur'},
    {min: 3, max: 10, message: "长度在3到10个字符", trigger: "blur"},
  ],
  password: [
    {required: true, message: '密码不能为空', trigger: 'blur'},
    {min: 6, max: 15, message: '密码位数只能在6~15之间', trigger: 'blur'},
    {validator: validatePass, trigger: 'blur'}
  ]
});

// 是否登录成功
const successMode = ref<boolean>(false)

// 登录按钮
async function submitForm() {
  const form = unref(loginFromRef)
  if (!form) {
    return
  }
  form.validate((valid) => {
    if (valid) {
      successMode.value = true
      // 路由跳转
      router.push('/axios')
    } else {
      console.log('error submit!!');
      return false;
    }
  })
}

// 重置表单
function resetForm() {
  // 笨办法这么写：
  // loginForm.value.email = ''
  // loginForm.value.pass = ''
  // 明眼人这么写：
  const form = unref(loginFromRef)
  form.resetFields()
}

</script>

<style scoped>

body {
  margin: 0px;
}

.container {
  background: url("../assets/images/loginback.png") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
  overflow: hidden;
}

.login_container {
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
