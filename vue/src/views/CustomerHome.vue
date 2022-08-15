<template>
  <div>
    <heading />
    <div class="greeting"> Hello {{this.$store.state.user.firstName }}</div>
    <!-- <div>This is a customer page. Hello {{this.$store.state.activeCustomer.customerId}}</div> -->
    <router-link v-bind:to="{name : 'requests'}"><div class="styled-box"><h3>View Your Repair Requests</h3></div></router-link>
    <router-link v-bind:to="{name : 'workOrderView'}"><div class="styled-box"><h3>View Your Work Order Estimates</h3></div></router-link>

    <!-- <router-link v-bind:to="{name : 'requests'}"><div class="styled-box"><h3>View Your Repair Estimates</h3></div></router-link> -->
    <!-- <add-vehicle /> -->
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
// import RequestService from "@/services/RequestService";
// import AddVehicle from '../components/AddVehicle.vue';

export default {
  name: "customer-home",
  components: {
    Heading,
    // AddVehicle,
  },
  created() {
    // RequestService.getLoggedInUser().then( response => {
    //   this.$store.commit("SET_USER", response.data);
    // })
  }
};
</script>

<style>
.greeting {
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