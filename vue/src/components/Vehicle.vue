<template>
  <div class="vehicle">
    <div v-for="vehicle in this.$store.state.vehicles" v-bind:key="vehicle.vehicleId" class="vehicle">
      {{vehicle.year}} {{vehicle.make}} {{vehicle.model}} {{ vehicle.color }}
    </div>
  </div>
</template>

<script>
import VehicleService from "@/services/VehicleService";

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
  created() {
    VehicleService.getVehicleById(this.$store.state.activeCustomer.customerId).then((response) => {
      this.$store.commit("SET_VEHICLES", response.data);
    });
  },
};
</script>

<style>
</style>