<template>
  <h1>{{showCelsius ? temperature.celsius : temperature.fahrenheit}}
    <a :href="showCelsius ? null : '#'" @click="showCelsius = !showCelsius">&#8451;</a>/
    <a :href="showCelsius ? '#' : null" @click="showCelsius = !showCelsius">&#8457;</a>
  </h1>
</template>

<script lang="ts">
import { ref, onMounted } from 'vue'
export default {
  name: 'CityWeather',
  props: {
    city: {
      type: String,
      required: true
    }
  },
  setup (props) {
    const temperature = ref({})
    const showCelsius = ref(true)

    onMounted(() => {
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.json())
        .then(data => { temperature.value = data })
    })

    const switchScale = () => {
      console.log('switchScale')
    }

    const href = '#'

    return {
      temperature,
      showCelsius,
      switchScale,
      href
    }
  }
}
</script>

<style scoped>

</style>
