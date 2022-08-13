<template>
  <div>
    <div class="repair" v-for="repair in repairs" v-bind:key="repair.id">
      Repair: {{ repair.repairName }}
      Parts Cost: {{ repair.partsCost }} 
      Labor Cost: {{ repair.laborCost }}
    </div>
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
font-family: Arial, Helvetica, sans-serif;
}  
</style>