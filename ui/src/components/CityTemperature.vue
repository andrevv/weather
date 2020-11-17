<template>
  <div class="temperature">
    <div class="summary">
      <p class="temp">{{temperature}}&#186;</p>
    </div>
    <div class="icon">
    </div>
  </div>
</template>

<script lang="ts">

import { defineComponent } from 'vue'

export default defineComponent({
  name: 'CityTemperature',
  components: {
  },
  props: {
    city: {
      type: String,
      required: true
    },
    temperature: {
      type: Number,
      required: true
    }
  },
  setup () {
    return {
    }
  }
})

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
