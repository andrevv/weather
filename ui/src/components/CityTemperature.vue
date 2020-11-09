<template>
  <div class="temperature">
    <div class="summary">
      <p class="temp">{{temperature}}&#186;</p>
    </div>
    <div class="icon">
      <CityWeatherIcon :name="description" />
    </div>
  </div>
</template>

<script lang="ts">

import { ref, onMounted } from 'vue'
import CityWeatherIcon from '@/components/CityWeatherIcon.vue'

export default {
  name: 'CityTemperature',
  components: {
    CityWeatherIcon
  },
  props: {
    city: {
      type: String,
      required: true
    }
  },
  setup (props) {
    const temperature = ref()
    const description = ref('')

    onMounted(() => {
      fetch(`/api/weather/cities/${props.city}`)
        .then(resp => resp.json())
        .then(data => {
          temperature.value = data.temperature.celsius
          description.value = data.description
        })
    })

    return {
      temperature,
      description
    }
  }
}

interface Temperature {
  celsius: number,
  fahrenheit: number
}

</script>

<style scoped>
.temperature {
  display: flex;
  text-align: center;
}

.temp {
  font-size: 2em;
}

.date {
  
}

.summary {
  flex: 1;
}

.icon {
  flex: 1;
}
</style>
