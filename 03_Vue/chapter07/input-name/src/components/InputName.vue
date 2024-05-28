<template>
  <div style="border: solid 1px gray; padding: 5px">
    <!-- name 속성을 input과 양방향 바인딩시킴 -->
    이름 : <input type="text" v-model="name" />
    <!-- 버튼 클릭시 nameChanged라는 이벤트에 name 값을 객체로 담아서 부모에게 전송 -->
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  data() {
    return { name: '' };
  },
};
</script>
