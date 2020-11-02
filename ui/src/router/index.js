import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/cities/moscow'
  },
  {
    path: '/cities/:city',
    name: 'city',
    props: ({ params, query }) => ({ city: params.city, scale: query.scale }),
    component: () => import(/* webpackChunkName: "city" */ '@/views/City.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
