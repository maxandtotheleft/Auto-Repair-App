<template>
  <div>
    <ul>
    <li class="repair" v-for="repair in repairs" v-bind:key="repair.id">
      Repair: {{ repair.repairName }}
      <p></p>
      Parts Cost: {{ repair.partsCost }} 
      <p></p>
      Labor Cost: {{ repair.laborCost }}
    </li>
    </ul>
  </div>
</template>

<script>
import WorkOrderService from "../services/WorkOrderService";
export default {
  name: "repair-list",
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
 .repair {
   display: flex;
   flex-direction: column;
  font-family: Arial, Helvetica, sans-serif;
  border: solid 1px black;
  margin: 10px;
  padding: 10px;
  border-radius: 15px 35px;
}  
</style>