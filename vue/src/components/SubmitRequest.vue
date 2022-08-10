<template>
  <div>
    <form class="submitForm" v-on:submit.prevent="addRequest">
      <!-- <label for="">Customer Id</label>
       <input type="" class="" id="" v-model="request.customerId" />  -->
      <label class="request-form-label">Vehicle Id</label>

      <input class="input" v-model="request.vehicleId" />
      <label class="request-form-label">Description</label>
      <input class="input" v-model="request.description" />

      <input class="submitB" type="submit" value="Save" />
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
    width: 400px;
    height: 200px;  
    overflow: hidden;  
    margin: left; 
    /* margin: auto; */
    /* margin: 20 0 0 450px;   */
    padding: 12px;
    margin-top: 25px;
    background:rgb(255, 255, 255);  
    /* background:grey; */
    /* border-radius: 15px 60px; */
    border: 1px solid  rgb(184, 176, 176);
    border-radius: 5px 35px;
    text-align: center;
  /* display: flex;
  flex-direction: column;
  color: white;
  width: 500px;
  text-align: center;
 padding: 20px;
 background-color: grey;
 border-radius: 5px 25px; 
 font-family: Arial, Helvetica, sans-serif; */
}

.request-form-label{
  margin-right: 280px;
  margin-top: 10px;
  padding-top: 10px;

}

.submitB{
  margin-left: 10px;
  margin-top: 10px;
  text-align: center;
  padding: 10px;
  font-weight: bold;
  border-block: 2px;
}

.input {
  display: flex;
  width: 95%;
  margin-right: 10px;
  margin-left: 5px;
  margin-top: 10px;
  margin-bottom: 10px;
  /* flex-direction: column; */
}
.text {
  font-family: Arial, Helvetica, sans-serif;
} 
</style>