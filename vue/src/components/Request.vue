<template>
  <div class="">
    <div v-bind:key="request.id" class="request">{{this.request.description}}
    </div>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";

export default {
 name: "Request",
  data() {
    return {
    request: {
        requestId: "",
        customerId: "",
        vehicleId: "",
        description: ""    
    } 
    };
  },
  created() {
    RequestService.getRequestById(1).then((response) => {
      this.request = response.data;
    });
  },
};
</script>

<style>

</style>