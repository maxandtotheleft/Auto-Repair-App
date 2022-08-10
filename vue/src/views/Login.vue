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
      <label id="label-login" for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label id="label-login" for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
       <button class="sign-in" type="submit">Sign in</button>

      <router-link :to="{ name: 'register' }" class="link-need-account">Need an account?</router-link>
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
        height: 350px;  
        overflow: hidden;  
        margin: auto;
        padding-bottom: 12px;
        margin-top: 25px;
        background:rgb(255, 255, 255);  
        border: 1.5px solid  rgb(184, 176, 176);
        border-radius: 15px 35px;
        text-align: center;
        
}

/* .password{
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px; 
    padding-top: 8px;
    display: flex;  
 }  */

.sr-only {
  display: flex;
  width: 300px;  
  height: 30px;  
  border-radius: 3px;
  padding-top: 8px;  
  padding-left: 70px; 
}

.sign-in{
  display: flex;
  margin-top: 20px;
  margin-left: 90px;
  margin-bottom: 15px;
  padding: 8px;
  font-weight: bold;
  border: 1px solid silver;
  border-radius: 10px;
}

#label-login{
  font-size: 17px;
  color: #00008b;
  /* color: white; */
  font-weight: bold;
  margin-left: 16px;

}

h1 {
  color: #00008b;
  /* color: white; */
}


</style>