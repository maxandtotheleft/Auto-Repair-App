<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'customer' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
body {
  background-image: url("https://mcdn.wallpapersafari.com/medium/51/78/dltnIv.jpg")
}
</style>
