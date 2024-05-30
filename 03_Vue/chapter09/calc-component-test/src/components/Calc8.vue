<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로 result 변경 -->
    <div>결과 : {{ state.result }}</div>
  </div>
</template>

<!-- composition API 내의 함수를 사용하려면 import필수 -->
<script>
import { reactive, watch } from 'vue';
export default {
  name: 'Calc6',
  setup() {
    const state = reactive({ x: 0, result: 0 });
    // 첫번째 인자 : 감시하고 싶은 데이터 (반응성 데이터)
    // 두번째 인자 : 현재값과 전의 값을 받아서 실행할 함수
    watch(() => {
      console.log(`${old}-> ${current}`);
      state.result = current * 2;
    });
    // return을 해줘야 template 쪽에서 사용 가능
    return { state };
  },
};
</script>
