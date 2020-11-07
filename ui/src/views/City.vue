<template>
  <div class="box-container">
    <div class="weather">
      <CityTemperature :city="city" />
    </div>
    <div class="forecast">
      <div class="today-temperature">
        <h1>33&#186;</h1>
        <p>Monday 16<sup>th</sup></p>
      </div>
      <div class="today-temperature-icon">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
      </div>
      <div class="forecast-item forecast1">
        <p>Tue</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>31&#186;</p>
      </div>
      <div class="forecast-item forecast2">
        <p>Wed</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>30&#186;</p>
      </div>
      <div class="forecast-item forecast3">
        <p>Thu</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>33&#186;</p>
      </div>
      <div class="forecast-item forecast4">
        <p>Fri</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>32&#186;</p>
      </div>
      <div class="forecast-item forecast5">
        <p>Sat</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>33&#186;</p>
      </div>
      <div class="forecast-item forecast6">
        <p>Sun</p>
        <p>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
        </p>
        <p>31&#186;</p>
      </div>
    </div>
  </div>
</template>

<!-- <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><path fill="#efefef" stroke="#efefef" stroke-miterlimit="10" stroke-width="3" d="M46.5 31.5h-.32a10.49 10.49 0 00-19.11-8 7 7 0 00-10.57 6 7.21 7.21 0 00.1 1.14A7.5 7.5 0 0018 45.5a4.19 4.19 0 00.5 0v0h28a7 7 0 000-14z"/><animateTransform attributeName="transform" dur="7s" repeatCount="indefinite" type="translate" values="-3 0; 3 0; -3 0"/></g></svg> -->

<script lang="ts">

import { defineComponent } from 'vue'
import CityTemperature from '@/components/CityTemperature.vue'

export default defineComponent({
  name: 'Home',
  components: {
    CityTemperature
  },
  props: {
    city: {
      type: String,
      default: 'moscow'
    }
  }
})
</script>

<style scoped>

sup {
  font-size: 0.7em;
}

.box-container {
  display: flex;
  border: goldenrod solid 10px;
  min-height: 50vh;
  flex-wrap: wrap;
}

.weather {
  background: rgba(79, 173, 235, 1);
  width: 100%;
}

.forecast {
  display: flex;
  width: 100%;
}

.today-temperature {
  width: 20%;
  text-align: center;
}

.today-temperature-icon {
  width: 20%;
  text-align: center;
}

.forecast-item {
  width: 10%;
  border-left: lightgrey solid 1px;
  margin: 20px 0 20px 0;
  text-align: center;
}

/* 
.temperature {
  background: tomato;
}

.forecast {
  background: mistyrose;
  border: 1px solid thistle;
  width: 10%;
}

.forecast1 {
}

.forecast2 {
}

.forecast3 {
}

.forecast4 {
}

.forecast5 {
}

.forecast6 {
} */

</style>
