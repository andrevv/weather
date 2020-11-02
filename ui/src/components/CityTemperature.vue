<template>
  <h1>{{showCelsius ? temperature.celsius : temperature.fahrenheit}}
    <a :href="showCelsius ? null : '#'" @click="showCelsius = !showCelsius">&#8451;</a>/
    <a :href="showCelsius ? '#' : null" @click="showCelsius = !showCelsius">&#8457;</a>
  </h1>
</template>

<script lang="ts">

import { ref, onMounted, reactive } from 'vue'

export default {
  name: 'CityTemperature',
  props: {
    city: {
      type: String,
      required: true
    },
    scale: {
      type: String,
      default: 'celsius'
    }
  },
  setup (props) {
    const temperature = reactive<Temperature>({
      celsius: 0,
      fahrenheit: 0
    })
    const showCelsius = ref(props.scale === 'celsius')

    onMounted(() => {
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.json())
        .then(data => {
          temperature.celsius = data.temperature.celsius
          temperature.fahrenheit = data.temperature.fahrenheit
        })
    })

    return {
      temperature,
      showCelsius
    }
  }
}

interface Temperature {
  celsius: number,
  fahrenheit: number
}

</script>

<style scoped>

</style>
