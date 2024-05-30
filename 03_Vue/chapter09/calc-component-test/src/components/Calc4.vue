<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로 result 변경 -->
    <div>결과 : {{ result }}</div>
  </div>
</template>

<!-- composition API 내의 함수를 사용하려면 import필수 -->
<script>
import { reactive, computed } from 'vue';
export default {
  name: 'Calc4',
  setup() {
    // computed로 계산해주기 때문에 result 초기화 필요 없어짐
    const state = reactive({ x: 10, y: 20, result: 30 });
    // 참조형 데이터는 .value로 접근할 필요 없다
    const result = computed(() => {
      return state.x + state.y;
    });
    // return을 해줘야 template 쪽에서 사용 가능
    return { state, result };
  },
};
</script>
