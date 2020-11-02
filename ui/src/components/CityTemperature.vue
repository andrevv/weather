<template>
  <h1>{{showCelsius ? temperature.celsius : temperature.fahrenheit}}
    <a :href="showCelsius ? null : '#'" @click="showCelsius = !showCelsius">&#8451;</a>/
    <a :href="showCelsius ? '#' : null" @click="showCelsius = !showCelsius">&#8457;</a>
  </h1>
</template>

<script lang="ts">

import { ref, onMounted } from 'vue'

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
    const temperature = ref({})
    const showCelsius = ref(props.scale === 'celsius')

    onMounted(() => {
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.json())
        .then(data => { temperature.value = data.temperature })
    })

    return {
      temperature,
      showCelsius
    }
  }
}
</script>

<style scoped>

</style>
