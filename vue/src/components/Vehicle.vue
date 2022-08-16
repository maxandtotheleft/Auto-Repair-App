<template>
  <div class="vehicle">
  
    <div v-for="vehicle in this.$store.state.vehicles" v-bind:key="vehicle.vehicleId" class="vehicle">
      <router-link v-bind:to="{name : 'history', params: {id: vehicle.vehicleId}}">{{vehicle.year}} {{vehicle.make}} {{vehicle.model}} {{ vehicle.color }}</router-link>
    </div>
    
  </div>
</template>

<script>
// import VehicleService from "@/services/VehicleService";

export default {
  name: "Vehicle",
  data() {
    return {
      // vehicles: [],
      // vehicle: {
      //   vehicleId: "",
      //   customerId: "",
      //   make: "",
      //   model: "",
      //   year: "",
      //   color: "",
      // }
    };
  },
  // created() {
  //   VehicleService.getVehicles().then((response) => {
  //     this.$store.commit("SET_VEHICLES", response.data);
  //   });
  // },
};
</script>

<style>
</style>