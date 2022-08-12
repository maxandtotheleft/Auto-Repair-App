<template>
  <div>
    <work-order-detail />
    <repair-list />
  </div>
</template>

<script>
import RepairList from "@/components/RepairList";
import WorkOrderDetail from "../components/WorkOrderDetail.vue";

export default {
  name: "work-order-view",
  components: {
    RepairList,
    WorkOrderDetail,
  },
};
</script>

<style>

</style>