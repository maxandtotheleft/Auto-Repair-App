<template>
  <div>
    <heading />
    <div class="greeting">
      <h1>Hello {{ this.$store.state.user.firstName }} </h1>
    </div>
    <div class="greeting">
      Your Employee ID is: {{ this.$store.state.user.id }}
    </div>
    <div class="work-order">
      <router-link :to="{ name: 'WorkOrders' }">View Work Orders</router-link>
    </div>
    <div class="reg"  v-if="
          this.$store.state.user.authorities.some(
            (authority) => authority.name === 'ROLE_ADMIN'
          )
        ">
      <router-link
        :to="{ name: 'registerEmployee' }"
        v-if="
          this.$store.state.user.authorities.some(
            (authority) => authority.name === 'ROLE_ADMIN'
          )
        "
        >Register an Employee</router-link
      >
    </div>
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import AuthService from "@/services/AuthService";
import RequestService from "@/services/RequestService";
import VehicleService from "@/services/VehicleService";
import WorkOrderService from "@/services/WorkOrderService";

export default {
  name: "employee-home",
  components: {
    Heading,
  },
  created() {
     AuthService.getAllUsers().then((response) => {
      this.$store.commit("SET_USERS", response.data);
    });
    RequestService.getEveryRequest().then((response) => {
      this.$store.commit("SET_REQUESTS", response.data);
    });
    VehicleService.getAllVehicles().then((response) => {
      this.$store.commit("SET_VEHICLES", response.data);
    });
    WorkOrderService.getWorkOrders().then((response) => {
      this.$store.commit("SET_WORKORDERS", response.data);
    })
  },
};
</script>

<style>
.work-order {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  margin: auto;
  padding: 25px;
  margin-top: 25px;
}
.greeting {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  margin: auto;
  padding: 25px;
  margin-top: 25px;
}

.reg { 
   font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  margin: auto;
  padding: 25px;
  margin-top: 25px;
  } 
</style>