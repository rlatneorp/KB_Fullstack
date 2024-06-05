<template>
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          <!-- 할 일의 내용을 표시하고 할일이 완료된 경우 '(완료)' 표시 -->
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        <!-- 스페이스 3칸 추가 -->
        &nbsp;&nbsp;&nbsp;
        <!-- 클릭시 해당 아이디를 가진 할 일이 삭제됨 -->
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <!-- 스토어의 doneCount에 접근해서 계산된 속성으로 만들어줌 -->
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { ref, computed } from 'vue';

// 값형 데이터이기 때문에 ref로 반응형 추가
const todo = ref('');

const todoListStore = useTodoListStore();
// 분해할당으로 스토어 내에서 리턴한 데이터들 가져옴
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

// 분해할당으로 받아두지 않은 값을 스토어명으로 접근해야함
const doneCount = computed(() => todoListStore.doneCount);

const addTodoHandler = () => {
  // ref 데이터 접근시에는 부모건 value로 접근
  addTodo(todo.value);
  // 추가적인 기능이 있을 때는 새로 핸들러를 만들어줌
  todo.value = '';
};
</script>
