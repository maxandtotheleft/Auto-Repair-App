<template>
  <div>
    <heading />
    <div class="styled-box"><work-order-detail /></div>
    <div class="styled-box"><repair-list /></div>
    <div class="styled-box"><repair-request /></div>

  </div>
</template>

<script>
import RepairList from "@/components/RepairList";
import WorkOrderDetail from "../components/WorkOrderDetail.vue";
import Heading from "../components/Heading.vue";
import RepairRequest from '../components/RepairRequest.vue'

export default {
  name: "work-order-view",
  components: {
    RepairList,
    WorkOrderDetail,
    Heading,
    RepairRequest
  },
};
</script>

<style>
</style>