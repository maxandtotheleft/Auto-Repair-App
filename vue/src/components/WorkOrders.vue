<template>
   <div class="workOrders">
    <div v-for="order in workOrders" v-bind:key="order.id"><router-link :to="{ name: 'workOrderView', params: {id: order.workOrderId} }">{{order.workOrderId}}</router-link>
    </div>
  </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";

export default {
name: "WorkOrders",
  data() {
    return {
    workOrders: [],
    workOrder: {
        workOrderId: "",
        employeeId: "",
        allCompleted: false,
        timeCompleted: ""  
    } 
    };
  },
  created() {

    // WorkOrderService.getWorkOrders().then((response) => {
    //   this.workOrders = response.data;
    // });
 WorkOrderService.getWorkOrdersByUserId(this.$store.state.activeEmployee.userId).then((response) => {
      this.workOrders = response.data;
    });
  },
}
</script>

<style>

</style>