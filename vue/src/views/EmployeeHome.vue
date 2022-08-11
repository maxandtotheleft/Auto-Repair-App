<template>
  <div>
    <heading />
    <router-link :to="{ name: 'registerEmployee'}" v-if="this.$store.state.user.authorities.some(authority => authority.name === 'ROLE_ADMIN')">Register an Employee</router-link>
    <router-link :to="{ name: 'WorkOrders'}">View Work Orders</router-link>
    <div>{{this.$store.state.activeEmployee.employeeId}}</div> 
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import RequestService from "@/services/RequestService";

export default {
  name: "employee-home",
  components: {
    Heading,
  },
   created() {
    RequestService.getEmployeeByUserId(this.$store.state.user.id).then( response => {
      this.$store.commit("SET_EMPLOYEE", response.data);
    })
  }
};
</script>

<style>
</style>