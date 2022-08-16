<template>
  <div>
    <heading />
    <div class="greeting"> <h1>Hello {{this.$store.state.user.firstName }}</h1></div>
    <!-- <div>This is a customer page. Hello {{this.$store.state.activeCustomer.customerId}}</div> -->
    <router-link v-bind:to="{name : 'requests'}"><div class="styled-box"><h3>View Your Repair Requests</h3></div></router-link>

    <!-- <router-link v-bind:to="{name : 'requests'}"><div class="styled-box"><h3>View Your Repair Estimates</h3></div></router-link> -->
    <!-- <add-vehicle /> -->
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import RequestService from "@/services/RequestService";
import VehicleService from "@/services/VehicleService";
import WorkOrderService from "@/services/WorkOrderService";

export default {
  name: "customer-home",
  components: {
    Heading,
    // AddVehicle,
  },
  created() {
    RequestService.getAllRequests().then((response) => {
      this.$store.commit("SET_REQUESTS", response.data);
    });
    VehicleService.getVehicles().then((response) => {
      this.$store.commit("SET_VEHICLES", response.data);
    });
    WorkOrderService.getWorkOrdersForUser().then((response) => {
      this.$store.commit("SET_WORKORDERS", response.data);
    });
  }
};
</script>

<style>

</style>