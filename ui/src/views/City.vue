<template>
  <div class="box-container">
    <div class="weather">
      <div class="city">
        <h1>{{cityName}}</h1>
        <p class="date">Monday {{dayOfMonth}}<sup>th</sup></p>
      </div>
      <div class="temperature">
        <CityTemperature :city="city" :date="date" />
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

import { defineComponent, ref, onMounted, computed } from 'vue'
import CityTemperature from '@/components/CityTemperature.vue'
import CityTemperatureForecast from '@/components/CityTemperatureForecast.vue'

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
    const forecasts = ref([])
    let weather = ref()
    const dayOfMonth = ref()
    const weekday = ref()

    const weekdays = [
      'Saturday',
      'Monday',
      'Tuesday',
      'Wednesday',
      'Thursday',
      'Friday',
      'Sunday'
    ]

    onMounted(async () => {
      const weatherResponse = await fetch(`/api/weather/cities/${props.city}`)
      weather.value = await weatherResponse.json()

      const date = new Date(weather.value.date)
      dayOfMonth.value = date.getDate()
      weekday.value = weekdays[date.getDay()]

      const r = await fetch(`/api/weather/cities/${props.city}/forecast`)
      const d = await r.json()
      forecasts.value = d.forecasts
    })

    const cityName = computed(() =>
      props.city.split(' ')
        .map(s => s.charAt(0).toUpperCase() + s.slice(1))
        .join(' '))

    return {
      weather,
      cityName,
      forecasts,
      dayOfMonth,
      weekday
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
