<template>
  <div class="requests">
    <div class="individual" v-for="request in this.$store.state.requests" v-bind:key="request.id">
      <router-link :to="{ name: 'workOrderView', params: {id: request.requestId} }">{{request.description}}</router-link>
    </div>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";

export default {
 name: "Request",
  data() {
    return {
    // requests: [],
    // request: {
    //     requestId: "",
    //     customerId: "",
    //     vehicleId: "",
    //     description: ""    
    // } 
    };
  },
  created() {
    // RequestService.getRequestById(1).then((response) => {
    //   this.request = response.data;
    // });
    RequestService.getAllRequests(this.$store.state.user.id).then((response) => {
        this.$store.commit("SET_REQUESTS", response.data);
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