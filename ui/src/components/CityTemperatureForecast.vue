<template>
  <p>{{label}}</p>
  <p>{{temperature}}&#186;</p>
</template>

<script lang="ts">

export default {
  name: 'CityTemperatureForecast',
  props: {
    date: {
      type: String,
      required: true
    },
    temperature: {
      type: Number,
      required: true
    }
  },
  setup (props) {
    const weekdays = [
      'monday',
      'tuesday',
      'wednesday',
      'thursday',
      'friday',
      'sunday',
      'saturday'
    ]

    const day = new Date(props.date).getDay()
    const label = weekdays[day].charAt(0).toUpperCase() + weekdays[day].substring(1, 3)

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
