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

      <div class="navigation-bar">
        
          <router-link @click="routeHomeButton()" class="hov"
            >Home</router-link
          >
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            class="hov"
            >Logout</router-link
          >
        
      </div>
    </div>

  </div>
</template>
<script>
export default {
  name: "heading",
  methods: {
    routeHomeButton(){
       if (this.$store.state.user.authorities.some(authority => authority.name === "ROLE_ADMIN") 
              || this.$store.state.user.authorities.some(authority => authority.name === "ROLE_EMPLOYEE")) {
              this.$router.push("/employee");
            } else {
              this.$router.push("/customer");
            }
      } 
    }
  }
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


.navigation-bar {
  display: flex;
  justify-content: space-around;
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
  font-family: Arial, Helvetica, sans-serif;
  color: white;
  padding: 20px;
  border: 0px solid black;
  text-decoration: none;
}

.nav-and-hours {
  margin: auto;
}
</style>