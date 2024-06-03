<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// const url = 'http://localhost:3000/todos/1';
// 해당 url에 있는 데이터를 가져와서 콘솔에 출력
const requestAPI = () => {
  const url = '/api/todos/1';
  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response);
  });
};
requestAPI();
</script>
