<template>
  <div>
    <button @click="fetchData">获取数据1</button>
    <div v-if="data">
      <p>{{ data }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      data: null
    };
  },
  methods: {
    fetchData() {
      // 发送GET请求到后端REST接口
      axios.get('http://192.168.1.107:8000', {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        withCredentials: false
    })
        .then(response => {
          // 成功获取数据
          this.data = response.data;
        })
        .catch(error => {
          // 处理错误
          console.error('Error fetching data:', error);
        });
    }
  }
}
</script>
