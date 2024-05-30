<template>
  <div>
    <NamedSlotTest />
    <SlotTest />
  </div>
</template>
<script>
import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';
export default {
  name: 'App',
  components: { NamedSlotTest, SlotTest },
};
</script>
