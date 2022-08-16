<template>
<div>
  <heading />
  <div class="styled-box">
    <h1>Open Work Orders</h1>
    <work-orders />
  </div>
  <div class="styled-box">
    <h1>Closed Work Orders</h1>
    <work-orders-inactive />
  </div>
</div>
</template>

<script>
import Heading from '../components/Heading.vue'
import WorkOrders from '../components/WorkOrders.vue'
import WorkOrdersInactive from '../components/WorkOrdersInactive.vue'
export default {
  components: { 
    WorkOrders,
    Heading,
    WorkOrdersInactive,

      },

}
</script>

<style>

h1 {
text-align: center;
} 

</style>