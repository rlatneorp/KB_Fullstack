<template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr />
    <ul>
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
    </ul>
  </div>
</template>
<script>
// 지역 컴포넌트 등록 방법 -> 사용할 파일에서만 명시
import CheckboxItem from './components/CheckboxItem.vue';

export default {
  name: 'App',
  components: {
    CheckboxItem,
  },
};
</script>
