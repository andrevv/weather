import { createApp } from 'vue'
import makeServer from './server'
import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

if (process.env.NODE_ENV !== 'production') {
  makeServer()
}

const app = createApp(App)

app.use(router)

app.mount('#app')
