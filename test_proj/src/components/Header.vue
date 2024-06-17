<template>
  <div class="header">
    <h1 class="headerName">가계부</h1>
    <div class="headerRight">
      <input type="date" />
    </div>
  </div>
</template>
<script setup>
// composition api에서 값형 데이터를 반응형으로 만들때 ref 사용
import { ref } from 'vue';
const isNavShow = ref(false);
</script>

<style>
body {
  background-color: #c1daf7;
}

.header {
  position: relative;
  width: 859px;
  height: 163px;
  background-color: white;
  border-radius: 30px;
  box-shadow: 10px 10px 10px 0px rgba(190, 190, 190, 0.48);
}
.headerName {
  display: inline;
  flex: left;
  margin-top: 40px;
  margin-left: 40px;
  font-weight: 700;
  font-size: 53px;
}
.headerRight {
  display: inline;
}
</style>
