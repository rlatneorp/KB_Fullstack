<template>
  <dv>
    <ScopedSlotTest />
  </dv>
</template>

<script>
import ScopedSlotTest from './components/ScopedSlotTest.vue';
export default {
  name: 'App',
  components: { ScopedSlotTest },
};
</script>
