<template>
  <h1>{{city}}</h1>
</template>

<script lang="ts">
export default {
  name: 'CityWeather',
  props: {
    city: {
      type: String,
      required: true
    }
  },
  setup () {
    return {
    }
  }
}
</script>

<style scoped>

</style>
