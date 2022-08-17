<template>
  <div>
    <heading />
    <history-custie-vehicle />
    <div class="styled-box">
      <h1>Active Work Orders</h1>
      <div v-for="orders in activeWorkOrders" v-bind:key="orders.id">
        <h2><router-link :to="{ name: 'workOrderView', params: {id: orders.workOrderId} }"> Order #{{ orders.workOrderId }}</router-link></h2>
        <div>
          <div>Completed: {{ orders.allCompleted }}</div>
          <div v-if="orders.timeCompleted" >Pick-up Time: {{ displayDate(orders.timeCompleted)}}</div>
           <div>Approved: {{ orders.approved }}</div>
            <div>Paid: {{ orders.paid }}</div>
        </div>
      </div>
      <h1>Inactive Work Orders</h1>
      <div v-for="orders in inactiveWorkOrders" v-bind:key="orders.id">
        <h2><router-link :to="{ name: 'workOrderView', params: {id: orders.workOrderId} }"> Order #{{ orders.workOrderId }}</router-link></h2>
        <div>
          <div>Completed: {{ orders.allCompleted }}</div>
          <div v-if="orders.timeCompleted">Pick-up Time: {{ displayDate(orders.timeCompleted)}}</div>
           <div>Approved: {{ orders.approved }}</div>
            <div>Paid: {{ orders.paid }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import Heading from "../components/Heading.vue";
import HistoryCustieVehicle from "../components/HistoryCustieVehicle.vue";


export default {
  components: {
    Heading,
    HistoryCustieVehicle,
    
  },
  name: "history",
  methods: {
       displayDate(timestamp) {
      if (timestamp) {
        return new Date(timestamp).toLocaleString();
      }
    },
    workOrdersFiltered(){
      return this.$store.state.workOrders.filter(workOrder => {
      return this.$store.state.requests.some(request => {
        return (workOrder.requestId === request.requestId) &&
          (request.vehicleId === this.$route.params.id); 
   });
  })
    },
  },
  computed: {
    activeWorkOrders() {
      return this.workOrdersFiltered().filter(
        workOrder => {
          return !(workOrder.allCompleted);
        }
      )

    },
    inactiveWorkOrders() {
      return this.workOrdersFiltered().filter(
        workOrder => {
          return workOrder.allCompleted;
        }
      )
    }
  
}
}

</script>

<style>
</style>