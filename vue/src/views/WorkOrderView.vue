<template>
  <div>
    <div class="wod"><work-order-detail /></div>
    <div class="rd"><repair-list /></div>
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
.rd{
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

.wod{
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