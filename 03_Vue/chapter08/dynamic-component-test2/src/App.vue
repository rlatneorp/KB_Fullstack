<template>
  <div>
    <!-- 자식의 name을 searchName으로 전달하고 다시 자식의 변경값을 받아옴 -->
    <!-- 주고받고 하는 과정을 아래코드로 생략가능 -->
    <InputName v-model:name="searchName" />
    <h3>검색어 : {{ searchName }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName.vue';

export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      searchName: 'John',
    };
  },
  methods: {
    // changeSearchName은 v-model로 명명한 바인딩시 생략 가능
    changeSearchName(name) {
      console.log(name);
      this.searchName = name;
    },
  },
};
</script>
<style>
.header {
  padding: 20px 0px 0px 20px;
}
.headerText {
  padding: 0px 20px 40px 20px;
}
.tab {
  padding: 30px;
}
</style>
