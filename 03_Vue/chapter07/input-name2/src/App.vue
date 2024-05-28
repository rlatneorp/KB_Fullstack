<template>
  <div>
    <!-- 자식 컴포넌트에서 정의한 nameChanged 이벤트를 nameChangedHandler 함수와 연결 -->
    <!-- (사용자 정의 이벤트) -->
    <inputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName.vue';

export default {
  name: 'App',
  components: {
    InputName,
  },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      // 받아온 객체 안에 있는 name을 접근해서 data에 있는 parentName에 넣어줌
      this.parentName = e.name;
    },
  },
};
</script>
