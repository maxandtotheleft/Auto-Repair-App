<template>
  <div>
    <heading />
    <div>This is a customer page. Hello</div>
    <!-- <div>This is a customer page. Hello {{this.$store.state.activeCustomer.customerId}}</div> -->
    <router-link v-bind:to="{name : 'requests'}">View Requests</router-link>
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import RequestService from "@/services/RequestService";

export default {
  name: "customer-home",
  components: {
    Heading,
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