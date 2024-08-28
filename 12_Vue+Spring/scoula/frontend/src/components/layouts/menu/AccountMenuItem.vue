<script setup>
defineProps({ username: String });

const { login, join } = config.accoutMenus;
import { useAuthStore } from '@/stores/auth.js';

const auth = useAuthStore();

const islogin = computed(() => auth.isLogin);
const username = computed(() => auth.username);
</script>

<template>
  <li class="nav-item">
    <router-link class="nav-link" to="/auth/profile">
      <i class="fa-solid fa-user"></i>
      {{ username }}
    </router-link>
  </li>
</template>
<style></style>
