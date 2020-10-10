import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/cities/:city',
    name: 'city',
    props: true,
    component: () => import(/* webpackChunkName: "cities" */ '@/components/CityWeather.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
