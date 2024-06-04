<template>
  <div class="row">
    <div class="col p-3">
      <!-- 링크클릭시 할일 목록으로 이동 -->
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <!-- template를 돌면서 todoitem 출력하고 자식에게 props로 todoitem전송 -->
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import { inject } from 'vue';
import TodoItem from '@/components/TodoItem.vue';
// app.vue가 provide의 todolist를 inject로 받아옴
const todoList = inject('todoList');
</script>
