<template>
  <div>
    <!-- 체크박스 변경시 id값과 현재 체크박스의 체크상태값을 check-changed이벤트에 담아서
      부모로 보냄 -->
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 체크박스가 체크 됐을 경우 span 태그 렌더링 -->
    <!-- 보여질 경우 이텔리체로 label출력 -->
    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
      ><i>{{ label }}</i></span
    >
    <!-- 체크 해제됐을 경우 렌더링 되는 span -->
    <span v-else style="color: gray">{{ label }}</span>
  </div>
</template>
<script>
// 부모 컴포넡트로부터 받을 속성들
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
};
</script>
