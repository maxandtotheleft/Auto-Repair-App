<template>
  <div class="big">
    <div class="logo"><img src="@/assets/AAMKLogoBlue.png" /></div>
    <div class="nav-and-hours">
      <div class="hours">
        <h3>Operating Hours</h3>
        <p><span>Monday-Friday</span> | <span>8am-5pm</span></p>
        <p>Saturday | 10am-4pm</p>
        <p>Sunday | Closed</p>
        <p>Holiday Hours May Vary</p>
      </div>

      <div class="navigation-bar">
        
          <div @click="routeHomeButton()" class="hov"
            >Home</div
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

}
.hours {
  height: 200px;
  width: 400px;
  background: rgb(255, 255, 255);
  border: 0.2px solid rgb(255, 255, 255);
  border-radius: 30px;
  color: #00008b;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}

.container {
  display: flex;
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  max-width: 100%;
  position: relative;
  background-repeat: no-repeat;
  flex-wrap: no-wrap;
}

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