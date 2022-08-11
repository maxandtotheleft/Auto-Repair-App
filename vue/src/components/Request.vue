<template>
  <div class="requests">
    <div class="individual" v-for="request in requests" v-bind:key="request.id">{{request.description}}
    </div>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";

export default {
 name: "Request",
  data() {
    return {
    requests: [],
    request: {
        requestId: "",
        customerId: "",
        vehicleId: "",
        description: ""    
    } 
    };
  },
  created() {
    // RequestService.getRequestById(1).then((response) => {
    //   this.request = response.data;
    // });
    RequestService.getAllRequests(this.$store.state.activeCustomer.customerId).then((response) => {
      this.requests = response.data;
    });
  },
};
</script>

<style>

/* .individual{
  border: 1px solid black; 
  padding: auto;
  margin: 1%;
} */

</style>