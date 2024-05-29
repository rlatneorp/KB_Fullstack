<template>
  <!-- 모듈로 등록한 스타일은 $style내에 저장됨 -->
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>
<script>
export default {
  name: 'Child3',
  created() {
    console.log(this.$style);
  },
};
</script>
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
