<template>
  <!-- idol을 객체로 받아왔으므로 idol안쪽의 속성에 .으로 접근 -->
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  // props: 부모 컴포넌트(App.vue)한테 받아온 속성
  // 받아올 속성이 많은 경우 객체를 통째로 넘겨준다.
  props: ['idol'],
};
</script>
