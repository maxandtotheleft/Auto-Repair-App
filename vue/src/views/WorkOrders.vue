<template>
<div>
  <heading />
  <div class="styled-box">
    <h1>Open Work Orders</h1>
    <work-orders />
  </div>
  <div class="styled-box">
    <h1>Closed Work Orders</h1>
  </div>
</div>
</template>

<script>
import Heading from '../components/Heading.vue'
// import WorkOrderRequest from '../components/WorkOrderRequest.vue'
import WorkOrders from '../components/WorkOrders.vue'
export default {
  components: { 
      WorkOrders,
    Heading,
    // WorkOrderRequest,
      },

}
</script>

<style>

h1 {
text-align: center;
} 

</style>