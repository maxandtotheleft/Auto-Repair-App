<template>
  <div>

    <div>
      <h1>Work Order #{{ workOrder.workOrderId }}</h1>
      <div>Completed: {{ this.workOrder.allCompleted }}</div>
      <div>Time Completed: {{ this.workOrder.timeCompleted }}</div>
      <div>Approved: {{ this.workOrder.approved }}</div>
      <div>Paid: {{ this.workOrder.paid }}</div>
    </div>
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
        requestId: "",
        allCompleted: false,
        timeCompleted: "",
        approved: false,
        paid: false,
      },
    };
  },
  created() {
    WorkOrderService.getWorkOrders().then((response) => {
      this.workOrder = response.data.find(
        (element) => element.workOrderId === this.$route.params.id
      );
    });
  },
};
</script>

<style>
</style>