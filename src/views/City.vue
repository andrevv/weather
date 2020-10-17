<template>
  <CityTemperature :city="city" />
</template>

<script lang="ts">

import { defineComponent } from 'vue'
import CityTemperature from '@/components/CityTemperature'

export default defineComponent({
  name: 'Home',
  components: {
    CityTemperature
  },
  props: {
    city: {
      type: String,
      default: 'moscow'
    }
  }
})
</script>

<style scoped>

</style>
