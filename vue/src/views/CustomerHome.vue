<template>
  <div>
    <heading />
    <div>This is a customer page. Hello {{this.$store.state.user.firstName }}</div>
    <!-- <div>This is a customer page. Hello {{this.$store.state.activeCustomer.customerId}}</div> -->
    <router-link v-bind:to="{name : 'requests'}">View Requests</router-link>
    <add-vehicle />
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import RequestService from "@/services/RequestService";
import AddVehicle from '../components/AddVehicle.vue';

export default {
  name: "customer-home",
  components: {
    Heading,
    AddVehicle,
  },
  created() {
    RequestService.getCustomerByUserId(this.$store.state.user.id).then( response => {
      this.$store.commit("SET_CUSTOMER", response.data);
    })
  }
};
</script>

<style>
</style>