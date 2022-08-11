<template>
  <div>
    <heading />
    <div class="vehicle-stuff">
      <h1>Your Vehicles</h1>
      <vehicle />
    </div>
    <div class="request-stuff">
      <h1>Requests</h1>
      <request />
    </div>

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
    Vehicle,
  },
};
</script>

<style scoped>
.request-stuff {
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

.vehicle-stuff {
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