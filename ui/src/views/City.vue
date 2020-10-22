<template>
  <div class="container">
    <div class="row justify-content-center">
      <CityTemperature :city="city" />
    </div>
  </div>
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
