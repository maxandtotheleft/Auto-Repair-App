<template>
  <div class="big">
    <!-- <div class="container"> -->
           <div class="nav-center">
           <ul class="navigation-bar">
      <router-link v-bind:to="{ name: 'customer' }" class="hov">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="hov">Logout</router-link>
           </ul>
           </div>
    
      <div class="logo"><img src="@/assets/AAMKLogoBlue.png" />
          <div class="hours">
        <p>Operating Hours</p>
        <p>Monday-Friday | 8am-5pm</p>
        <p>Saturday | 10am-4pm</p>
        <p>Sunday | Closed</p>
        <p>Holiday Hours May Vary</p>
      </div>
         <!-- <div class="loginout" id="nav">
           <ul class="navigation-bar">
      <router-link v-bind:to="{ name: 'customer' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
           </ul>
    </div> -->
    </div>
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
  /* border: solid 2px black; */
}
.hours {
  height: 200px;
  width: 400px;
  background: linear-gradient(
    45deg,
    black,
    gray 80%,
    gray,
    grey 80%,
    black
  );
  color: #fff;
  padding: 10px 0px 0px 10px;

  margin: 40px 0px 0px 35px;
  text-align: center;
  /* text-align: left;
  white-space: pre-wrap;
    */
  border: solid 0px black;
  border-radius: 5px;
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
   position: absolute;
   
  
}

.text-center {
  width: 200px;
}

.loginout{
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
  background-color: white;
  float: right;
} 

.navigation-bar{
   list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

.nav-center{
  float: left;
  display: block;
  text-align: center;
  padding: 16px;
  text-decoration: none;
}

.hov:hover{
  background: #00008b;
}

.hov{
  color: white;
  padding: 20px;

}

</style>