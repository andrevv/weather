<template>
  <p>{{label}}</p>
  <p>{{temperature}}&#186;</p>
</template>

<script lang="ts">

export default {
  name: 'CityTemperatureForecast',
  props: {
    weekday: {
      type: String,
      required: true
    },
    temperature: {
      type: Number,
      required: true
    }
  },
  setup (props) {
    const label = props.weekday.charAt(0).toUpperCase() + props.weekday.substring(1, 3)

    return {
      label: label
    }
  }
}

</script>

<style scoped>
  p {
    font-size: 1.2em;
  }
</style>
