<template>
  <div>
    <heading />
    <div class="styled-box"><customer-vehicle-info /></div>
    <div class="styled-box"><work-order-detail /></div>
    <div class="styled-box" id="repairs"><repair-list /></div>
    <div class="styled-box"  v-if="($store.state.isEmployee) || ($store.state.isAdmin)"><repair-request /></div>
  </div>
</template>

<script>
import RepairList from "@/components/RepairList";
import WorkOrderDetail from "../components/WorkOrderDetail.vue";
import Heading from "../components/Heading.vue";
import RepairRequest from "../components/RepairRequest.vue";
import CustomerVehicleInfo from "../components/CustomerVehicleInfo.vue";

export default {
  name: "work-order-view",
  components: {
    RepairList,
    WorkOrderDetail,
    Heading,
    RepairRequest,
    CustomerVehicleInfo
  },
};
</script>

<style>

</style>