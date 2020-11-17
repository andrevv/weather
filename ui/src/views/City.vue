<template>
  <div class="box-container">
    <div class="weather">
      <div class="city">
        <h1>{{capitalize(city)}}</h1>
        <p class="date">{{dayOfWeek}} {{dayOfMonth}}<sup>th</sup></p>
      </div>
      <div class="temperature">
        <CityTemperature :city="city" :temperature="weather.temperature" />
      </div>
    </div>
    <div class="forecast">
      <div class="forecast-item" v-for="forecast in forecasts" :key="forecast.date">
        <CityTemperatureForecast :date="forecast.date" :temperature="forecast.temperature" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">

import { defineComponent, toRefs } from 'vue'
import CityTemperature from '@/components/CityTemperature.vue'
import CityTemperatureForecast from '@/components/CityTemperatureForecast.vue'
import useWeather from '@/hooks/useWeather'
import useForecast from '@/hooks/useForecast'
import { dayOfWeek, dayOfMonth } from '@/lib/date'
import { capitalize } from '@/lib/string'

export default defineComponent({
  name: 'City',
  components: {
    CityTemperature,
    CityTemperatureForecast
  },
  props: {
    city: {
      type: String,
      default: 'moscow'
    }
  },
  setup (props) {
    const { city } = toRefs(props)

    const { weather } = useWeather(city)
    const { forecasts } = useForecast(city)

    return {
      weather,
      forecasts,
      capitalize,
      dayOfWeek: dayOfWeek(weather.date),
      dayOfMonth: dayOfMonth(weather.date)
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
  display: flex;
  align-content: center;
}

.temperature {
  width: 40%;
  display: flex;
  justify-content: center;
}

.forecast {
  display: flex;
  width: 100%;
  height: 15vh;
  justify-content: center;
}

.forecast-item {
  width: 10%;
  border-left: lightgrey solid 1px;
  margin: 0px 0 0 0;
  text-align: center;
}

.forecast-item:first-child {
  border-left: none;
}

</style>
