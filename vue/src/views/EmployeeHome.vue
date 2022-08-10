<template>
  <div>
    <heading />
    <div>This is an employee page</div>
    <router-link :to="{ name: 'registerEmployee'}" v-if="this.$store.state.user.authorities.some(authority => authority.name === 'ROLE_ADMIN')">Register an Employee</router-link>
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";

export default {
  name: "employee-home",
  components: {
    Heading,
  },
};
</script>

<style>
</style>