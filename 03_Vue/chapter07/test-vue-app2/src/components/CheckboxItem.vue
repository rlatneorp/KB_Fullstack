<template>
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  // props: 부모 컴포넌트(App.vue)한테 받아온 속성
  props: ['name', 'checked'], //속성명을 배열로 정의
};
</script>
