<template>
  <div>
    <h2>관심있는 K-POP가수는?</h2>
    <hr />
    <ul>
      <!-- idol은 idols라는 이름으로 객체 하나씩 접근 -->
      <!-- 자식에 등록된 props와 동일한 이름으로 넘겨줘야 한다 -->
      <CheckboxItem
        v-for="idol in idols"
        :key="idol.id"
        :id="idol.id"
        :name="idol.name"
        :checked="idol.checked"
      />
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
  data() {
    return {
      // idols를 객체 배열로 만들어줌
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink' },
        { id: 3, name: 'EXO' },
        { id: 4, name: 'ITZY' },
      ],
    };
  },
};
</script>
