<template>
   <div class="workOrders">
    <div v-for="order in workOrders" v-bind:key="order.id">{{order.workOrderId}}
    </div>
  </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";

export default {
name: "WorkOrder",
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

    WorkOrderService.getWorkOrders().then((response) => {
      this.workOrders = response.data;
    });

  },
}
</script>

<style>

</style>