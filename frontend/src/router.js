import { createRouter, createWebHistory } from 'vue-router';
import Home from './views/Home.vue';
import EventDetails from './views/EventDetails.vue';
import Blog from './views/BlogPost.vue';
import BlogDetail from './views/BlogDetail.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/blog', component: Blog },
  { path: '/blogDetails', name: 'blogDetail', component: BlogDetail },
  { path: '/events/:id', name: 'EventDetails', component: EventDetails, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;


