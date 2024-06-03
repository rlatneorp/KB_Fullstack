<template>
  <div class="card card-body">
    <h2>404 Not Found</h2>
    <!-- fullPath : 현재 경로 뽑아내기 -->
    <p>존재하지 않는 요청 경로 : {{ $route.fullPath }}</p>
  </div>
</template>

<script>
export default {
  name: 'NotFound',
  created() {
    // 컴포넌트가 생성될 때 전달된 파라미터를 출력
    console.log(this.$route.params);
  },
};
</script>
