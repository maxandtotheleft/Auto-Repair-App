<template>
   <div class="workOrders">
    <div v-for="order in workOrders" v-bind:key="order.id">
      <router-link :to="{ name: 'workOrderView', params: {id: order.workOrderId} }">
      {{order.workOrderId}}
      {{customer(request(order.requestId).customerId).lastName}}
      {{vehicle(request(order.requestId).vehicleId).color}}
      {{vehicle(request(order.requestId).vehicleId).year}}
      {{vehicle(request(order.requestId).vehicleId).make}}
      {{vehicle(request(order.requestId).vehicleId).model}}
      </router-link>
    </div>
  </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";
// import RequestService from "@/services/RequestService";
// import AuthService from "@/services/AuthService";

export default {
name: "WorkOrders",
  data() {
    return {
    workOrders: [],
    workOrder: {
        workOrderId: "",
        requestId: "",
        allCompleted: false,
        timeCompleted: "",
        approved: false,
        paid: false 
    }
    };
  },
  created() {

    WorkOrderService.getWorkOrders().then((response) => {
      this.workOrders = response.data;
    });

    // AuthService.getAllUsers().then((response) => {
    //   this.users = response.data;
    // })


      // RequestService.getRequestById(1).then((response) => {
      //   const customerId = response.data.customerId;
      //   AuthService.getUser(customerId).then((response) => {
      //     console.log(response.data.lastName)
      //   })
      // })
    

//  WorkOrderService.getWorkOrdersByUserId(this.$store.state.activeEmployee.userId).then((response) => {
//       this.workOrders = response.data;
//     });
  },
  methods: {
    request(requestId){
      return this.$store.state.requests.find(request => request.requestId === requestId);
    },
    customer(customerId) {
      return this.$store.state.users.find(customer => customer.id = customerId);
    },
    vehicle(vehicleId) {
      return this.$store.state.vehicles.find(vehicle => vehicle.vehicleId = vehicleId);
    }
  },
  // methods: {
  //   getCustomerInfo(requestId) {
  //     return RequestService.getRequestById(requestId).then((response) => {
  //       const customerId = response.data.customerId;
  //       return this.users.find(user => user.id === customerId)
  //     })
  //   }
  // }
}
</script>

<style>

</style>