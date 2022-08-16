<template>
  <div>{{getVehicleByWorkOrder()}}</div>
</template>

<script>
import AuthService from "@/services/AuthService";
import RequestService from "@/services/RequestService";
import VehicleService from "@/services/VehicleService";
export default {

  methods: {
      getVehicleByWorkOrder(){
        let request = RequestService.getRequestById(this.$route.params.id);
        let vehicle = this.$store.state.vehicles.find(element => element.customerId == request.customerId);
        return vehicle;
      } 
  },
  created(){
       AuthService.getAllUsers().then((response) => {
      this.$store.commit("SET_USERS", response.data);
    });
    // RequestService.getRequestById().then((response) => {
    //   this.$store.commit("SET_REQUESTS", response.data);
    // });
    VehicleService.getAllVehicles().then((response) => {
      this.$store.commit("SET_VEHICLES", response.data);
    })

  }
};
</script>

<style>
</style>