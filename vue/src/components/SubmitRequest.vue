<template>
  <div>
    <form class="submitForm" v-on:submit.prevent="addRequest">
      <!-- <label for="">Customer Id</label>
       <input type="" class="" id="" v-model="request.customerId" />  -->
      <label>Vehicle Id</label>

      <input class="input" v-model="request.vehicleId" />
      <label>Description</label>
      <input class="input" v-model="request.description" />

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
        if (response.status === 201 || response.status === 200) {
          this.$router.push("/customer");
        }
      });
    },
  },
  created() {
    this.request.customerId = this.$store.state.activeCustomer.customerId;
  },
};
</script>

<style>
.submitForm {
  display: flex;
  flex-direction: column;
  color: white;
  width: 500px;
  text-align: center;
 padding: 20px;
 background-color: grey;
 border-radius: 5px 25px; 
 font-family: Arial, Helvetica, sans-serif;
}

.input {
  display: flex;
  flex-direction: column;
}
.text {
  font-family: Arial, Helvetica, sans-serif;
} 
</style>