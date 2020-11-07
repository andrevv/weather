<template>
  <div class="container main">
    <div class="row justify-content-center">
      <ul>
        <li>
          <router-link :to="{ name: 'city', params: { city: 'berlin' } }">Berlin</router-link>
        </li>
        <li>
          <router-link :to="{ name: 'city', params: { city: 'london' } }">London</router-link>
        </li>
        <li>
          <router-link :to="{ name: 'city', params: { city: 'moscow' } }">Moscow</router-link>
        </li>
      </ul>
    </div>
    <div class="col">
      <router-view :key="$route.fullPath"></router-view>
    </div>
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

.main {
  margin-top: 50px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
}

li {
  float: left;
}

li a {
  display: block;
  padding: 16px;
  text-align: center;
  text-decoration: none;
}

li a.router-link-active {
  color: black;
}

li a.router-link-exact-active {
  color: black;
}

</style>
