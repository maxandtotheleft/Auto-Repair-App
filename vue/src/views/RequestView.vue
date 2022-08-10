<template>
  <div>
    <heading />
    <h1>Your Vehicles</h1>
    <vehicle />
    <h1>Requests</h1>
    <request />
    <submit-request />
  </div>
</template>

<script>
import Heading from "../components/Heading.vue";
import Request from "../components/Request.vue";
import SubmitRequest from "../components/SubmitRequest.vue";
import Vehicle from "../components/Vehicle.vue";

export default {
  // name: '',
  components: {
    Request,
    SubmitRequest,
    Heading,
    Vehicle
  },
};
</script>

<style scoped>
</style>