<template>
  <IconClear v-if="weatherName === 'clear'"/>
  <IconRain v-if="weatherName === 'rain'"/>
  <IconCloudy v-if="weatherName === 'cloudy'"/>
  <IconSnow v-if="weatherName === 'snow'"/>
</template>

<script lang="ts">

import { defineComponent, computed } from 'vue'
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
  },
  setup (props) {
    const weatherName = computed(() => props.name.toLowerCase())

    return {
      weatherName: weatherName
    }
  }
})

</script>