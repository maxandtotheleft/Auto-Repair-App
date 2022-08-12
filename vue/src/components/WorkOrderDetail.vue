<template>
  <div>
      <div v-for="repair in repairs" v-bind:key="repair.id">{{repair.repairId}}</div>
  </div>
</template>

<script>
import WorkOrderService from "../services/WorkOrderService";
export default {
  name: "workOrderDetail",
  data() {
    return {
      repairs: [],
    };
  },
  created() {
    WorkOrderService.getRepairsByWorkOrderId(this.$route.params.id).then(
      (response) => {
        this.repairs = response.data;
      }
    );
  },
};
</script>

<style>
</style>