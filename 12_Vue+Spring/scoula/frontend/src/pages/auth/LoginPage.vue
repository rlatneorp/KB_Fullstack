<script setup>
import { computed, reactive, ref } from 'vue';
import { useAuthStore } from '@/stores/auth';
import { useRouter } from 'vue-router';

const router = useRouter();
const auth = useAuthStore();

// 로그인 폼에 사용될 객체 생성
const member = reactive({
  username: '',
  password: '',
});

const error = ref(''); // 에러 메시지 담을 객체

// 제출 버튼 비활성화 여부를 판단하는 속성(username과 paswword가 둘다 입력되어있는지 체크)
const disableSubmit = computed(() => !(member.username && member.password));

const login = async () => {
  console.log(member);
  try {
    await auth.login(member); // 인증 스토어에서 로컬 스토리지에 해당 사용자 정보 저장
    router.push('/'); // 로그인 성공시 홈 화면으로 이동
  } catch (e) {
    // 로그인 에러
    console.log('에러=======', e);
    error.value = e.response.data;
  }
};
</script>

<template>
  <div class="mt-5 mx-auto" style="width: 500px">
    <h1 class="my-5">
      <i class="fa-solid fa-right-to-bracket"></i>
      로그인
    </h1>
<!--    prevent : preventDefault 기본 동작 실행 안함 (서버 전송)-->
    <form @submit.prevent="login">
      <div class="mb-3 mt-3">
        <label for="username" class="form-label">
          <i class="fa-solid fa-user"></i>
          사용자 ID:
        </label>
        <input
          type="text"
          class="form-control"
          placeholder="사용자 ID"
          v-model="member.username"
        />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">
          <i class="fa-solid fa-lock"></i>
          비밀번호:
        </label>
        <input
          type="password"
          class="form-control"
          placeholder="비밀번호"
          v-model="member.password"
        />
      </div>
<!--      error는 String인데 v-if에 들어갔으면 에러 메시지가 있으면 true라는 것-->
      <div v-if="error" class="text-danger">{{ error }}</div>
<!--      버튼 비활성화 여부를 disableSubmit 값으로 처리함-->
      <button
        type="submit"
        class="btn btn-primary mt-4"
        :disabled="disableSubmit"
      >
<!--        제출 버튼-->
        <i class="fa-solid fa-right-to-bracket"></i>
        로그인
      </button>
    </form>
  </div>
</template>
