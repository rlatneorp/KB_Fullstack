<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ state.result }}</div>
  </div>
</template>

<!-- composition API 내의 함수를 사용하려면 import필수 -->
<script>
import { reactive } from 'vue';
export default {
  name: 'Calc3',
  setup() {
    // ref로 값형 데이터를 감싸줘야 반응형으로 동작한다
    // 기존 옵션 API의 data와 같은 역할
    const state = reactive({ x: 10, y: 20, result: 30 });
    // 참조형 데이터는 .value로 접근할 필요 없다
    const calcAdd = () => {
      state.result = state.x + state.y;
    };
    // return을 해줘야 template 쪽에서 사용 가능
    return { state, calcAdd };
  },
};
</script>
