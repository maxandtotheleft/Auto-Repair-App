<template>
  <div class="request">
    <div v-for="request in requests" v-bind:key="request.id" class="request">{{request.description}}
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
    RequestService.getAllRequests(this.$store.state.activeCustomer.customerId).then((response) => {
      this.requests = response.data;
    });
  },
};
</script>

<style>
.request {
  display: flex;
  flex-direction: column;
  border: solid 1px black; 
  width: 500px;
  padding: 5px;
  margin: 5px;
} 
</style>