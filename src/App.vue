<template>
  <div>
    <router-link :to="{ name: 'city', params: { city: 'berlin' } }">Berlin</router-link> |
    <router-link :to="{ name: 'city', params: { city: 'london' } }">London</router-link> |
    <router-link :to="{ name: 'city', params: { city: 'moscow' } }">Moscow</router-link>
    <router-view></router-view>
  </div>
</template>

<script lang="ts">
export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
</style>
