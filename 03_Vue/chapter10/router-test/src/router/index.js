import { createRouter, createWebHistory } from 'vue-router';
// ../아 @/ 모두 src 폴더를 나타냄
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home', // name 속성은 필 수가 아님
      // 무조건 로딩되어야 하는 페이지가 있기 때문에 정적으로 처리
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      // 해당 경로가 방문됐을때만 로딩되게 만들어둠, 화살표함수로 처리
      // component: () => import('../views/AboutView.vue'),
      component: About,
    },
    {
      path: '/members',
      component: Members,
    },
    {
      path: '/videos',
      component: Videos,
    },
    // 어떤 문자던지 위에서 해당되지 않는 경로는 다 여기서 처리
    // 404 라우트
    { path: '/:paths(.*)*', name: 'NotFound', component: NotFound },
  ],
});

// router 만들고 내보내기
export default router;
