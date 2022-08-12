<template>
<div>
  <heading />
<div class="orders">
  <h1>Your Work Orders</h1>
  <work-orders />
  <work-order-detail />
  </div>
  </div>
</template>

<script>
import Heading from '../components/Heading.vue'
import WorkOrderDetail from '../components/WorkOrderDetail.vue'
import WorkOrders from '../components/WorkOrders.vue'
export default {
  components: { 
      WorkOrders,
    Heading,
    WorkOrderDetail 
      },

}
</script>

<style>
h1 {
text-align: center;
} 

.orders {
   font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
    height: auto;  
    overflow: hidden;  
    /* margin: left;  */
    margin: auto;
    /* margin: 20 0 0 450px;   */
    padding: 25px;
    margin-top: 25px;
} 
</style>