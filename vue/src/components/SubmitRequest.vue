<template>
  <div>
    <form class="" v-on:submit.prevent="addRequest">
      <label for="">Customer Id</label>
       <input type="" class="" id="" v-model="request.customerId" /> 
       <label for="">Vehicle Id</label>
       <input type="" class="" id="" v-model="request.vehicleId" /> 
            <label for="">Description</label>
       <input type="" class="" id="" v-model="request.description" />
        <input type="submit" value="Save" />
    </form>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";
export default {
  data() {
    return {
      request: {
        requestId: "",
        customerId: "",
        vehicleId: "",
        description: "",
      },
    };
  },
  name: "SubmitRequest",
  methods: {
    addRequest() {
      RequestService.addRequest(this.request).then((response) => {
        if (response.status === 201 || response.status === 200 ) {
          this.$router.push("/customer");
        }
      });
    },
  },
};
</script>

<style>
</style>