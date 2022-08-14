<template>
  <div>
    <form class="submitForm" v-on:submit.prevent="addRequest">
      <!-- <label for="">Customer Id</label>
       <input type="" class="" id="" v-model="request.customerId" />  -->
      <label class="request-form-label">Vehicle
        <select v-model="request.vehicleId">
          <option
            v-for="vehicle in this.$store.state.vehicles"
            v-bind:key="vehicle.vehicleId"
            :value="vehicle.vehicleId"
          >
          {{vehicle.year}} {{vehicle.make}} {{vehicle.model}} {{ vehicle.color }}
          </option>
        </select>
      </label>
      <!-- <input class="input" v-model="request.vehicleId" /> -->
      <label class="request-form-label">Description</label>
      <textarea class="input-text-area" v-model="request.description"></textarea>

      <input class="submitB" type="submit" value="Save" />
    </form>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";
// import VehicleService from "@/services/VehicleService";

export default {
  data() {
    return {
      request: {
        vehicleId: "",
        description: "",
      },
      customerVehicles: []
    };
  },
  name: "SubmitRequest",
  methods: {
    addRequest() {
      RequestService.addRequest(this.request).then((response) => {
        if (response.status === 201 || response.status === 200) {
          // this.$router.go()

          // Adds repair request to vue store
          const requests = [...this.$store.state.requests]
          requests.push(response.data);
          this.$store.commit("SET_REQUESTS", requests);

          // reset the form
          this.request = {}
        }
      });
    },
  },
  created() {
    // this.request.customerId = this.$store.state.activeCustomer.customerId;
  },
};
</script>

<style>
.submitForm {
    font-family: Arial, Helvetica, sans-serif;
    width: 400px;
    height: 300px;  
    overflow: hidden;  
    /* margin: left;  */
    margin: auto;
    /* margin: 20 0 0 450px;   */
    padding: 25px;
    margin-top: 25px;
    background:rgb(255, 255, 255);  
    /* background:grey; */
    /* border-radius: 15px 60px; */
    border: 1px solid  rgb(184, 176, 176);
    border-radius: 15px 35px;
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
  margin-right: 24px;
  margin-bottom: 20px;
  margin-top: 20px;
  font-size: 17px;
  color: #00008b;
  font-weight: bold;
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
  height: 25px;
  margin-right: 10px;
  margin-left: 5px;
  margin-top: 20px;
  margin-bottom: 15px;
  /* flex-direction: column; */
}

.input-text-area{
  display: flex;
  width: 95%;
  height: 100px;
  margin-right: 10px;
  margin-left: 5px;
  margin-top: 20px;
  margin-bottom: 15px;
  border: 2px solid silver;
  border-radius: 10px;
}

.text {
  font-family: Arial, Helvetica, sans-serif;
} 
</style>