<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은?(첫번째:Slot사용(X))</h3>
    <!-- items 배열을 순회하면서 자식의 props에 해당 값들을 넘겨준다 -->
    <!-- 자식에서 보낸 check-changed 이벤트에 CheckBoxChanged 함수 연결 -->
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    ></CheckBox1>
  </div>
</template>

<script>
import CheckBox1 from './CheckBox1.vue';

export default {
  name: 'NoSlotTest',
  components: { CheckBox1 },
  data() {
    return {
      items: [
        {
          id: 'V',
          checked: true,
          label: 'Vue',
        },
        {
          id: 'A',
          checked: false,
          label: 'Angular',
        },
        {
          id: 'R',
          checked: false,
          label: 'React',
        },
        {
          id: 'S',
          checked: false,
          label: 'Svelte',
        },
      ],
      methods: {
        CheckBoxChanged(e) {
          // 변경된 체크박스의 id로 현재 items 배열에서 해당 요소를 찾는다.
          let item = this.items.find((item) => item.id === e.id);
          // 해당 아이템의 checked 값을 받아온 값으로 변경
          item.checked = e.checked;
        },
      },
    };
  },
};
</script>
