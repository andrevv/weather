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
    return {
      label: props.weekday.substr(0, 3)
    }
  }
}

</script>
