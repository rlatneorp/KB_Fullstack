<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = async () => {
  const url = '/api/todos';
  // API 요청에 성공했을때
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log('# 응답객체 : ', response);
    // API 요청에 실패했을때
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    // instanceof: e가 error 파일인지 체크
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};
requestAPI();
</script>
