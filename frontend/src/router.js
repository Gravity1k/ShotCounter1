import { createRouter, createWebHistory } from 'vue-router';
import Home from './views/Home.vue';
import EventDetails from './views/EventDetails.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/events/:id', name: 'EventDetails', component: EventDetails, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

// comment to make it work possiblt 

