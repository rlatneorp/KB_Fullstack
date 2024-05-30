<template>
  <!-- 부모한테 받아온 props인 name을 value 값으로 지정 -->
  <!-- input입력시 input의 value값을 unpate-name 이벤트로 부모에 넘겨줌 -->
  <input
    type="text"
    :value="name"
    @input="$emit('update-name', $event.target.value)"
  />
</template>
<script>
export default {
  name: 'InputName',
  props: ['name'],
};
</script>
