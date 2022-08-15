<template>
<div>
  <heading />
  <div class="orders">
    <h1>Open Work Orders</h1>
    <work-orders />
  </div>
  <div class="orders">
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

.orders {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;  
  overflow: hidden;  
  margin: auto;
  padding: 25px;
  margin-top: 25px;
} 

.submit {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;  
  overflow: hidden;  
  margin: auto;
  padding: 25px;
  margin-top: 25px;
}
</style>