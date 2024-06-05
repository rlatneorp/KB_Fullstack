<template>
  <div class="container">
    <Header />
    <!-- 계속 페이지가 바뀌는 부분이 router-view -->
    <router-view />
    <Loading v-if="states.isLoading" />
  </div>
</template>

<script setup>
import axios from 'axios';
// script setup 키워드 사용시 components 따로 등록할 필요 없음
import Header from '@/components/Header.vue';
import { reactive, computed, provide } from 'vue';
import Loading from '@/components/Loading.vue';

const BASEURI = '/api/todos';
const states = reactive({ todoList: [] });
// const states = reactive({
//   todoList: [
//     { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
//     { id: 2, todo: 'React학습', desc: '설명2', done: false },
//     { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
//     { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
//   ],
// });

// todolist 목록 조회하는 메소드
const fetchTodoList = async () => {
  states.isLoading = true;
  // try catch 문 예외 처리 구문
  // try : 예외가 발생할 수 있는 문장을 넣는다
  try {
    states.isLoading = false;
    // 서버에서 데이터를 가져올때 시간이 걸리기 때문에 await 비동기처리
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      // states가 200인 건 요청이 성공적으로 이루어졌다는 뜻
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
    // catch : 예외로 어떻게 처리할지 적어둠
  } catch (error) {
    alert('에러발생 :' + error);
  }
};

// todo를 추가하는 메소드, todo와 desc가 들어있는 객체를 구조 분해 할당으로 받음
const addTodo = async ({ todo, desc }, successCallback) => {
  states.isLoading = true;
  try {
    states.isLoading = false;
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  // todoList의 맨 뒤에 새로운 객체 추가
  // states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};

// todo를 수정하는 메소드, 해당 id의 todo를 찾아서 todo desc done 값을 업데이트
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  states.isLoading = true;
  try {
    states.isLoading = false;
    const payload = { id, todo, desc, done };
    // 해당 아이디를 가진 할일 전체를 업데이트 해줌
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      // 받아온 id를 해당하는 todo를 찾은 후 해당 todo의 index 반환
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert('Todo 변경 실패');
    }
  } catch (error) {
    alert('에러 발생 :' + error);
  }
};

// todo를 수정하는 메소드, 해당 id의 todo를 찾아서 todo, desc, done 값을 업데이트
// const updateTodo = ({ id, todo, desc, done }) => {
//   // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // 찾아온 todo의 값을 그대로 펼친 후 todo, desc, done 값을 업데이트해서 다시 대입
//   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
// };

// todo를 삭제하는 메소드, 해당 id의 todo를 찾아서 삭제
const deleteTodo = async (id) => {
  states.isLoading = true;
  try {
    states.isLoading = false;
    const response = await axios.delete(BASEURI + `/${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러 발생 :' + error);
  }
};
// todo를 삭제하는 메소드, 해당 id의 todo를 찾아서 삭제
// const deleteTodo = (id) => {
//   // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // todolist에서 해당 index에 있는 객체 한개를 삭제함
//   states.todoList.splice(index, 1);
// };

const toggleDone = async (id) => {
  states.isLoading = true;
  try {
    states.isLoading = false;
    // 받아온 id로 해당하는 todo를 찾아옴
    let todo = states.todoList.find((todo) => todo.id === id);
    // todo의 아이디를 그대로 가져오고 done값만 반대로 변경해줌
    let payload = { ...todo, done: !todo.done };
    // done이 변경됐으므로 해당 아이디의 todo를 업데이트 해줌
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료 변경 실패');
    }
  } catch (error) {
    alert('에러 발생 :' + error);
  }
};

// todo의 done을 true -> false, false -> true로 변경해주는 메소드
// const toggleDone = (id) => {
//   // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
//   let index = states.todoList.findIndex((todo) => todo.id === id);
//   // 해당 todo의 done 값을 반대로 바꿔줌
//   states.todoList[index].done = !states.todoList[index].done;
// };

// provide로 하위 컴포넌트에서 사용 가능하도록 제공해줌
provide(
  'todoList',
  // computed로 감싸주면 반응성과 읽기전용 유지
  computed(() => states.todoList)
);
provide('actions', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

// 전체 목록 갱신
fetchTodoList();
</script>
