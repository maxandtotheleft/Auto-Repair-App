<template>
  <div>
    <heading />
    <history-custie-vehicle />
    <div class="styled-box">
      <div v-for="orders in this.$store.state.workOrders" v-bind:key="orders.id">
        <h1><router-link :to="{ name: 'workOrderView', params: {id: orders.workOrderId} }"> Order #{{ orders.workOrderId }}</router-link></h1>
        <div>
          <div>Completed: {{ orders.allCompleted }}</div>
          <div>Pick-up Time: {{ displayDate(orders.timeCompleted)}}</div>
           <div>Approved: {{ orders.approved }}</div>
            <div>Paid: {{ orders.paid }}</div>
        </div>
      </div>
    </div>
    <!-- <div class="styled-box"><customer-vehicle-info /></div>
    <div class="styled-box"><work-order-detail /></div>
    <div class="styled-box" id="repairs"><repair-list /></div> -->
  </div>
</template>

<script>
// import RepairList from "@/components/RepairList";
// import WorkOrderDetail from "../components/WorkOrderDetail.vue";
import Heading from "../components/Heading.vue";
import HistoryCustieVehicle from "../components/HistoryCustieVehicle.vue";
// import CustomerVehicleInfo from "../components/CustomerVehicleInfo.vue";

export default {
  components: {
    Heading,
    HistoryCustieVehicle,
    // CustomerVehicleInfo,
    // WorkOrderDetail,
    // RepairList,
  },
  name: "history",
  methods: {
       displayDate(timestamp) {
      if (timestamp) {
        return new Date(timestamp).toLocaleString();
      }
  }
}
}

</script>

<style>
</style>