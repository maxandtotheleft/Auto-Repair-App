<template>
  <div>
    <heading />
    <div>This is a customer page</div>
    <router-link v-bind:to="{name : 'requests'}">View Requests</router-link>
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";

export default {
  name: "customer-home",
  components: {
    Heading,
  },
};
</script>

<style>
</style>