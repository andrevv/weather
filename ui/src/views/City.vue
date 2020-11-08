<template>
  <div class="box-container">
    <div class="weather">
      <h1>{{city}}</h1>
    </div>
    <div class="forecast">
      <div class="today-temperature">
        <CityTemperature :city="city" />
        <CityDate />
      </div>
      <div class="today-temperature-icon">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64"><g><circle cx="32" cy="32" r="11.64" fill="#f4a71d"/><path fill="none" stroke="#f4a71d" stroke-linecap="round" stroke-miterlimit="10" stroke-width="3" d="M32 15.71V9.5M32 54.5v-6.21M43.52 20.48l4.39-4.39M16.09 47.91l4.39-4.39M20.48 20.48l-4.39-4.39M47.91 47.91l-4.39-4.39M15.71 32H9.5M54.5 32h-6.21"/></g></svg>
      </div>
      <div class="forecast-item forecast1">
        <CityTemperatureForecast weekday="tuesday" temperature="31" />
      </div>
      <div class="forecast-item forecast2">
        <CityTemperatureForecast weekday="wednesday" temperature="30" />
      </div>
      <div class="forecast-item forecast3">
        <CityTemperatureForecast weekday="thursday" temperature="33" />
      </div>
      <div class="forecast-item forecast4">
        <CityTemperatureForecast weekday="friday" temperature="32" />
      </div>
      <div class="forecast-item forecast5">
        <CityTemperatureForecast weekday="saturday" temperature="33" />
      </div>
      <div class="forecast-item forecast6">
        <CityTemperatureForecast weekday="sunday" temperature="31" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">

import { defineComponent } from 'vue'
import CityTemperature from '@/components/CityTemperature.vue'
import CityTemperatureForecast from '@/components/CityTemperatureForecast.vue'
import CityDate from '@/components/CityDate.vue'

export default defineComponent({
  name: 'Home',
  components: {
    CityTemperature,
    CityTemperatureForecast,
    CityDate
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
  min-height: 50vh;
  flex-wrap: wrap;
}

.weather {
  background: rgba(79, 173, 235, 1);
  width: 100%;
  height: 30vh;
  color: white;
  padding: 20px;
}

.forecast {
  display: flex;
  width: 100%;
  height: 20vh;
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
