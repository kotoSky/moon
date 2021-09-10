<template>
  axios
</template>

<script setup>

import axios from '../utils/axios'

axios.get("user/getInfo")
  .then((res) => {
    console.log("请求成功")
  })
  .catch((err) => {
    console.log('请求失败')
  })

</script>

<style scoped>

</style>
