<template>
<div>
<heading />
  <div id="login">
    <form class="form-signin" @submit.prevent="login">
      <h1 id="signin">Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thanks for registering, please sign in.</div>
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
      <div>
      <router-link :to="{ name: 'register' }" class="link-need-account">Need an account?</router-link>
      </div>
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
        userId: "",
      //  firstName: ""
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
            if (this.$store.state.user.authorities.some(authority => authority.name === "ROLE_ADMIN")) {
              this.$store.commit("SET_ADMIN", true);
            }
            if (this.$store.state.user.authorities.some(authority => authority.name === "ROLE_EMPLOYEE")) {
              this.$store.commit("SET_EMPLOYEE", true);
            }
            if (this.$store.state.user.authorities.some(authority => authority.name === "ROLE_USER")) {
              this.$store.commit("SET_CUSTOMER", true);
            }


            if (this.$store.state.isAdmin || this.$store.state.isEmployee) {
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
        height: 100%;  
        overflow: hidden;  
        margin: auto;
        padding: 10px 20px 30px 20px;
        margin-top: 25px;
        background:rgb(255, 255, 255);  
        border-radius: 15px 35px;
        text-align: center;      
}

.sr-only {
  display: flex;
  width: 300px;  
  height: 30px;  
  border-radius: 3px;
  padding-top: 8px;  
  padding-left: 70px;
  font-size: 17px;
  color: #00008b;
  font-weight: bold;
  margin-left: 16px; 
}

.sign-in{
  display: flex;
  margin-top: 15px;
  margin-left: 90px;
  margin-bottom: 15px;
  padding: 9px 14px 9px 14px;
  font-weight: bold;
  border: 1.5px solid silver;
  border-radius: 10px;
  font-family: "Assistant", Arial, Helvetica, sans-serif;
  border-block: 2px;
}

#label-login{
  font-family: 'Assistant', Arial, Helvetica, sans-serif;
  font-size: 17px;
  color: #00008b;
  /* font-weight: bold; */
  margin-left: 16px; 
} 

#signin {
  font-family: 'Racing Sans One', Arial, Helvetica, sans-serif;
}

.link-need-account {
  font-family: 'Assistant', Arial, Helvetica, sans-serif;
} 

</style>