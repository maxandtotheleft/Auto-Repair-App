<template>
  <div>
    <heading />
    <div class="styled-box">
      <h1>Your Vehicles</h1>
      <vehicle />
      <button class="buttonstyle"  @click="viewAddVehiclePage">Add Vehicle</button>
    </div>
    <div class="styled-box">
      <h1>Your Repair Requests</h1>
      <request />
    </div>
    <div class="styled-box">
      <h1>Create a Repair Request</h1>
      <submit-request />
    </div>
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
    Vehicle,
  },
  methods: {
    viewAddVehiclePage() {
      this.$router.push({ name: "add-vehicle" });
    },
  },
};
</script>

<style>

</style>