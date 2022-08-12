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
    WorkOrderService.getWorkOrdersByUserId(this.$store.state.activeEmployee.userId).then((response) => {
      this.workOrder = response.data.find (element => element.workOrderId === this.$route.params.id);
    });
  },
}
</script>

<style>

</style>