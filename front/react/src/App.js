import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './App.css';

const MyComponent = () => {
  const [data, setData] = useState(null);

  const fetchData = async () => {
    try {
      // 发送GET请求到后端REST接口
      const response = await axios.get('http://192.168.1.107:8000');
      
      // 将返回的JSON数据解析并存储在state中
      setData(response.data);
    } catch (error) {
      // 处理错误
      console.error('Error fetching data:', error);
    }
  };

  useEffect(() => {
    // 在组件挂载时调用fetchData
    fetchData();
  }, []); // 通过空数组作为第二个参数确保fetchData只在组件挂载时调用一次

  return (
    <div>
        <div>
          <p>{data}</p>
        </div>
    </div>
  );
};

export default MyComponent;
