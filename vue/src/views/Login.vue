<template>
<div>
<heading />
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
       <button class="sign-in" type="submit">Sign in</button>

      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <!-- <button type="submit">Sign in</button> -->
    </form>
  </div>
  </div>
</template>

<script>
import Heading from '../components/Heading.vue';
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {Heading},
  data() {
    return {
      user: {
        username: "",
        password: "",
        role: "",
        userId: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if (this.$store.state.user.authorities.some(authority => authority.name === "ROLE_ADMIN") 
              || this.$store.state.user.authorities.some(authority => authority.name === "ROLE_EMPLOYEE")) {
              this.$router.push("/employee");
            } else {
              this.$router.push("/customer");
            }
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
#login{  
        width: 250px;
        height: 300px;  
        overflow: hidden;  
        /* margin: left;  */
        margin: auto;
        /* margin: 20 0 0 450px;   */
        padding: 12px;
        margin-top: 25px;
        background:rgb(255, 255, 255);  
         /* background:grey; */
        /* border-radius: 15px 60px; */
        border: 1px solid  rgb(184, 176, 176);
        border-radius: 5px 35px;
        text-align: center;
        
}

.password{
    width: 300px;  
    height: 30px;  
    /* border: none;   */
    border-radius: 3px;  
    padding-left: 8px; 
    padding-top: 8px;
    display: flex; 
   
}

.sr-only {
  display: flex;
  width: 300px;  
    height: 30px;  
    /* border: none;   */
    border-radius: 3px;
    padding-top: 8px;  
    padding-left: 40px; 
    text-align: center;
}

.sign-in{
  display: flex;
  margin-top: 20px;
  margin-left: 90px;
  margin-bottom: 20px;
  padding: 8px;
  font-weight: bold;
  border-block: 2px;
  /* background-color: rgb(223, 240, 247); */
}

label{
  font-size: 17px;
  color: #00008b;
  /* color: white; */
  font-weight: bold;
}

h1 {
  color: #00008b;
  /* color: white; */
}

</style>