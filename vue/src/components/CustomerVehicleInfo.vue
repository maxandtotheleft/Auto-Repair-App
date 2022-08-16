<template>
  <div>
    <h1>Customer Information:</h1>
    <div>{{this.customer.firstName}} {{this.customer.lastName}}</div>
    <div>{{this.customer.phoneNumber}}</div>
    <div>{{this.customer.emailAddress}}</div>
    <h2>Vehicle Information:</h2>
    <div>{{this.vehicle.color}} {{this.vehicle.year}} {{this.vehicle.make}} {{this.vehicle.model}}</div>
    
  </div>
</template>

<script>
import AuthService from "@/services/AuthService";
import RequestService from "@/services/RequestService";
import VehicleService from "@/services/VehicleService";
export default {
  data() {
    return {
    customer: {
        id: "",
        username: "",
        authorities: "",
        firstName: "",
        lastName: "",
        emailAddress: "",
        phoneNumber: ""   
    },
    vehicle: {
        vehicleId: "",
        customerId: "",
        make: "",
        model: "",
        year: "",
        color: "",
      }
    };
  },

  created(){
       AuthService.getAllUsers().then((response) => {
      this.$store.commit("SET_USERS", response.data);
    });
    RequestService.getEveryRequest().then((response) => {
      this.$store.commit("SET_REQUESTS", response.data);
    });
    VehicleService.getAllVehicles().then((response) => {
      this.$store.commit("SET_VEHICLES", response.data);
    });
    let request = this.$store.state.requests.find(element => element.requestId === this.$route.params.id);
    let vehicle = this.$store.state.vehicles.find(element => element.customerId === request.customerId);
    this.vehicle = vehicle;

    let customer = this.$store.state.users.find(element => element.id === request.customerId);
    this.customer = customer;

  }
};
</script>

<style>
</style>