<template>
  <li><input type="checkbox" :checked="checked" />옵션1</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  data() {
    return {
      checked: false,
    };
  },
};
</script>
