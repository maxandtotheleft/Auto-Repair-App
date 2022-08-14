<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'customer' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-view />
  </div>
</template>

<style>
body {
  background-image: url("https://mcdn.wallpapersafari.com/medium/51/78/dltnIv.jpg")
}

.styled-box {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  /* margin: left;  */
  margin: auto;
  /* margin: 20 0 0 450px;   */
  padding: 25px;
  margin-top: 25px;
}

</style>
