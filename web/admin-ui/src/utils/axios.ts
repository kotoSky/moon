import Axios from 'axios'
import {ElLoading, ElMessage} from 'element-plus'

const baseURL = '/api/'

const axios = Axios.create({
  baseURL,
  timeout: 5000, // 请求超时 5s
  headers: {
    'Content-Type': 'application/json;charset=UTF-8;',
  }
})

let loading: any;
//正在请求的数量
let requestCount: number = 0
//显示loading
const showLoading = () => {
  if (requestCount === 0 && !loading) {
    loading = ElLoading.service({
      text: "Loading  ",
      background: 'rgba(0, 0, 0, 0.7)',
      spinner: 'el-icon-loading',
    })
  }
  requestCount++;
}
//隐藏loading
const hideLoading = () => {
  requestCount--
  if (requestCount == 0) {
    loading.close()
  }
}

// 前置拦截器（发起请求之前的拦截）
axios.interceptors.request.use(
  (config) => {
    showLoading();
    /**
     * 根据你的项目实际情况来对 config 做处理
     * 这里对 config 不做任何处理，直接返回
     */
    let token = localStorage.getItem("token");
    if (token) {
      config.headers['Authorization'] = token;
    }
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

// 后置拦截器（获取到响应时的拦截）
axios.interceptors.response.use(
  (response) => {
    hideLoading();
    /**
     * 根据你的项目实际情况来对 response 和 error 做处理
     * 这里对 response 和 error 不做任何处理，直接返回
     */
    return response
  },
  (error) => {
    if (error.response && error.response.data) {
      const code = error.response.status
      const msg = error.response.data.message
      ElMessage.error(`Code: ${code}, Message: ${msg}`)
      console.error(`[Axios Error]`, error.response)
    } else {
      ElMessage.error(`${error}`)
    }
    return Promise.reject(error)
  }
)

export default axios
