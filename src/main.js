import { createApp } from 'vue'
import makeServer from './server.js'
import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

makeServer()

const app = createApp(App)

app.use(router)

app.mount('#app')
