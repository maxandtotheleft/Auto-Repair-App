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
  background-image: url("https://mcdn.wallpapersafari.com/medium/51/78/dltnIv.jpg");
}

.styled-box {
  font-family: "Assistant", Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  margin: auto;
  padding: 25px;
  margin-top: 25px;
  text-decoration: none;
}

a {
  text-decoration: none;
}

h1, h2 {
    color: hsl(240, 100%, 27%);
}


.buttonstyle {
  margin-left: 10px;
  margin-top: 10px;
  text-align: center;
  padding: 9px 14px 9px 14px;
  font-weight: bold;
  font-family: "Assistant", Arial, Helvetica, sans-serif;
  border-radius: 10px;
  border: 1.5px solid silver;
  border-block: 2px;
}
</style>
