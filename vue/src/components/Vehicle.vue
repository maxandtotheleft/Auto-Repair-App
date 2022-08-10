<template>
  <div class="vehicle">
    <div v-for="vehicle in vehicles" v-bind:key="vehicle.id" class="vehicle">{{ vehicle.color }}
    </div>
  </div>
</template>

<script>
import VehicleService from "@/services/VehicleService";

export default {
  name: "Vehicle",
  data() {
    return {
      vehicles: [],
    //   vehicle: {
    //     vehicleId: "",
    //     customerId: "",
    //     make: "",
    //     model: "",
    //     year: "",
    //     color: "",
    //   }
    };
  },
  created() {
    VehicleService.getVehicleById(this.$store.state.activeCustomer.customerId).then((response) => {
      this.vehicles = response.data;
    });
  },
};
</script>

<style>
</style>