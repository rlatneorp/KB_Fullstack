<template>
  <Layout>
    <!-- slot을 전달해줄때는 무조건 자식 컴포넌트의 사이에 넣어준다 -->
    <template v-slit:header>
      <h2>헤더 영역</h2>
    </template>
    <template v-slit:sidebar>
      <h2>사이드</h2>
      <h2>사이드</h2>
      <h2>사이드</h2>
    </template>
    <template v-slit:default>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
      <h2>컨텐츠 영역</h2>
    </template>
    <template v-slit:footer>
      <h2>Footer Text</h2>
    </template>
  </Layout>
</template>

<script>
import Layout from './components/Layout.vue';
export default {
  name: 'App',
  components: { Layout },
};
</script>
