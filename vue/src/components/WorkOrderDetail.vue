<template>
  <div>
      {{ this.workOrder.timeCompleted}}
      </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";

export default {
name: "WorkOrderDetails",
  data() {
    return {
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
      this.workOrder = response.data.find (element => element.workOrderId === this.$route.params.id);
    });
  },
}
</script>

<style>

</style>