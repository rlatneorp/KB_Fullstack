<template>
  <!-- 가운데 정렬을 위해 부트스트랩의 container 클래스 삽입 -->
  <div id="app" class="container">
    <InputTodo />
    <TodoList />
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

export default {
  name: 'App',
  //  import와 짝궁! 컴포넌트로 등록해줘야 함
  components: { InputTodo, TodoList },
};
</script>
