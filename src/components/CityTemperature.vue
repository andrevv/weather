<template>
  <h1>{{temperature}} &#8451;</h1>
</template>

<script lang="ts">
import { ref, onUpdated } from 'vue'
export default {
  name: 'CityWeather',
  props: {
    city: {
      type: String,
      required: true
    }
  },
  setup (props) {
    const temperature = ref(0);

    onUpdated(() => {
      console.log('onMounted')
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.text())
        .then(data => { temperature.value = parseInt(data) })
    })

    return {
      temperature
    }
  }
}
</script>

<style scoped>

</style>
