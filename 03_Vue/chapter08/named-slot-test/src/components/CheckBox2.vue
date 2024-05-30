<template>
  <div>
    <!-- item이라는 이름의 slot을 받아옴 -->
    <slot name="item"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- slot으로 부모에서 보낸 span을 전달받는다 -->
    <!-- 부모에서 온 데이터가 없을 경우 기본값인 'Item'이 출력된다 -->
    <slot>Item</slot>
  </div>
</template>
<script>
// 부모 컴포넡트로부터 받을 속성들
export default {
  name: 'CheckBox2',
  props: ['id', 'checked', 'label'],
};
</script>
