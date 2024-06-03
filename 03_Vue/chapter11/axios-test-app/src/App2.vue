<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// const url = 'http://localhost:3000/todos/1';
// 해당 url에 있는 데이터를 가져와서 콘솔에 출력
const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      // 헤당 url에 있는 데이터를 가져와서 전체리스트 출력
      console.log('# TodoList : ', todoList);
      return todoList[0].id;
    })
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    }) // 받아온 데이터 출력 후 두번째 todo id 출력
    .then((response) => {
      console.log('## 첫번째 Todo : ', response.data);
      return todoList[1].id;
    }) // 두번째 todo아이디로 데이터 받아와서 출력
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo : ', response.data);
      });
    });
};
requestAPI();
</script>
