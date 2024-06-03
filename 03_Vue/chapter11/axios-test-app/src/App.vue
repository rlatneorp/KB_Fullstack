<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const requestAPI = () => {
  const url = 'http://localhost:3000/todos/1';
  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response);
  });
};

requestAPI();
</script>
