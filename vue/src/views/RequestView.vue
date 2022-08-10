<template>
  <div>
    <heading />
    <h1>Requests</h1>
    <request />
    <submit-request />
  </div>
</template>

<script>
import Heading from "../components/Heading.vue";
import Request from "../components/Request.vue";
import SubmitRequest from "../components/SubmitRequest.vue";

export default {
  // name: '',
  components: {
    Request,
    SubmitRequest,
    Heading,
  
  },
};
</script>

<style scoped>
</style>