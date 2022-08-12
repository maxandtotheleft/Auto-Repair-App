<template>
  <div class="big">
    <!-- <div class="container"> -->
    <div class="logo"><img src="@/assets/AAMKLogoBlue.png" /></div>
    <div class="nav-and-hours">
      <div class="hours">
        <p>Operating Hours</p>
        <p>Monday-Friday | 8am-5pm</p>
        <p>Saturday | 10am-4pm</p>
        <p>Sunday | Closed</p>
        <p>Holiday Hours May Vary</p>
      </div>

      <div>
        <ul class="navigation-bar">
          <router-link v-bind:to="{ name: 'customer' }" class="hov"
            >Home</router-link
          >
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            class="hov"
            >Logout</router-link
          >
        </ul>
      </div>
    </div>

    <!-- <div class="loginout" id="nav">
           <ul class="navigation-bar">
      <router-link v-bind:to="{ name: 'customer' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
           </ul>
    </div> -->
  </div>
</template>
<script>
export default {
  name: "heading",
};
</script>


<style>
.big {
  display: flex;
  width: 100%;
  height: 350px;
  background-size: cover;
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  background-repeat: no-repeat;
  column-count: 3;
  column-rule-style: solid;
  column-gap: 40px;
  justify-content: space-around;
  align-items: center;
  /* border: solid 2px black; */
}
.hours {
  height: 200px;
  width: 400px;
  background: #00008b;
  border: 2px solid black;
  border-radius: 30px;
  color: #fff;
  /* padding: 10px 0px 0px 10px;
  margin: 60px 0px 0px 0px; */
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
}

.container {
  display: flex;
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  max-width: 100%;
  position: relative;
  /* float: left; */
  background-repeat: no-repeat;
  flex-wrap: no-wrap;
}

/* .container2 {
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  background-repeat: no-repeat;
  display: flex;
  width: 60%;
  float: right;
  justify-content: center;
} */

.logo {
  margin: 35px;
  /* position: absolute; */
}

.text-center {
  width: 200px;
}

/* .loginout{
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
  background-color: white;
  float: right;
}  */

.navigation-bar {
  display: flex;
  justify-content: space-between;
  list-style-type: none;
  max-width: 100%;
  margin: 10px;
  overflow: hidden;
  background-color: #333;
  border: solid 0px black;
  border-radius: 30px;
}

.hov:hover {
  background: #00008b;
}

.hov {
  color: white;
  padding: 20px;
  border: 1px solid black;
}

.nav-and-hours {
  margin: auto;
}
</style>