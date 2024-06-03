<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';
// 해당 url에 있는 데이터를 가져와서 콘솔에 출력

// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  const url = '/api/todos';
  // post 메소드의 body부분에 해당함
  let data = { todo: '윗몸 일으키기 3세트', desc: '너무 빠르지 않게 ...' };
  // 해당 url에 data를 담아서 넘김
  const resp1 = await axios.post(url, data);
  console.log(resp1.data);
};
requestAPI();
</script>
