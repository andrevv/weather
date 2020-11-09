<template>
  <div class="box-container">
    <div class="weather">
      <h1>{{cityName}}</h1>
    </div>
    <div class="forecast">
      <div class="today-temperature">
        <CityTemperature :city="city" />
        <CityDate />
      </div>
      <div class="today-temperature-icon">
        <CityWeatherIcon :name="description" />
      </div>
      <div class="forecast-item forecast1">
        <CityTemperatureForecast weekday="tuesday" temperature="31" />
        <IconRain />
      </div>
      <div class="forecast-item forecast2">
        <CityTemperatureForecast weekday="wednesday" temperature="30" />
        <IconCloudy />
      </div>
      <div class="forecast-item forecast3">
        <CityTemperatureForecast weekday="thursday" temperature="33" />
        <IconSnow />
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

import { defineComponent, ref, onMounted, computed } from 'vue'
import CityTemperature from '@/components/CityTemperature.vue'
import CityTemperatureForecast from '@/components/CityTemperatureForecast.vue'
import CityDate from '@/components/CityDate.vue'
import CityWeatherIcon from '@/components/CityWeatherIcon.vue'

export default defineComponent({
  name: 'City',
  components: {
    CityTemperature,
    CityTemperatureForecast,
    CityDate,
    CityWeatherIcon
  },
  props: {
    city: {
      type: String,
      default: 'moscow'
    }
  },
  setup (props) {
    const description = ref('')

    onMounted(() => {
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.json())
        .then(data => {
          description.value = data.description
        })
    })

    const cityName = computed(() =>
      props.city.split(' ')
        .map(s => s.charAt(0).toUpperCase() + s.slice(1))
        .join(' '))

    return {
      description,
      cityName
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
