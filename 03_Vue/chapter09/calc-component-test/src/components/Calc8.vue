<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /> <br />
    <!-- computed 함수로 인해 바뀌는 값에 따라 바로 result 변경 -->
    <div>결과 : {{ result }}</div>
  </div>
</template>

<!-- composition API 내의 함수를 사용하려면 import필수 -->
<script>
import { ref, watchEffect } from 'vue';
export default {
  name: 'Calc8',
  setup() {
    const x = ref(10);
    const y = ref(20);

    const result = ref(30);
    // watch함수를 간편하게 쓰기 위해 만들어진 함수
    // 인자로는 함수 하나만 받으며 참조하고 있는 데이터가 하나라도 변경되면 호출된다
    // computed와의 차이점 : return을 하지 않는다
    watchEffect(() => {
      result.value = x.value + y.value;
      console.log(`${x.value} + ${y.value} = ${result.value}`);
    });
    // return을 해줘야 template 쪽에서 사용 가능
    return { x, y, result };
  },
};
</script>
