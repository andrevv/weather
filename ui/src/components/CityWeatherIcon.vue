<template>
  <IconClear v-if="name === 'clear'"/>
  <IconRain v-if="name === 'rain'"/>
  <IconCloudy v-if="name === 'cloudy'"/>
  <IconSnow v-if="name === 'snow'"/>
</template>

<script lang="ts">

import { defineComponent } from 'vue'
import IconClear from '@/components/IconClear.vue'
import IconRain from '@/components/IconRain.vue'
import IconCloudy from '@/components/IconCloudy.vue'
import IconSnow from '@/components/IconSnow.vue'

export default defineComponent({
  name: 'CityWeatherIcon',
  components: {
    IconClear,
    IconRain,
    IconCloudy,
    IconSnow
  },
  props: {
    name: {
      type: String,
      required: true
    }
  }
})

</script>