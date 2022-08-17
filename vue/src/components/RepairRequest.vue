<template>
  <div>
    <form @submit.prevent="addRepair">
      <p class="orderForm">Repair Name</p>
      <input type="text" v-model="repair.repairName" />
      <p></p>
      <p class="orderForm">Parts Cost</p>
      <input type="text" v-model="repair.partsCost" />
      <p></p>
      <p class="orderForm">Labor Cost</p>
      <input type="text" v-model="repair.laborCost" />
      <p></p>
      <p class="orderForm">Completed</p>
      <input type="checkbox" v-model="repair.completed" />
      <p class="orderForm"></p>
      <input class="buttonstyle" type="submit" value="Save" />
    </form>
  </div>
</template>

<script>
import WorkOrderService from "../services/WorkOrderService";
export default {
  data() {
    return {
      repair: {
        workOrderId: this.$route.params.id,
        repairName: "",
        partsCost: "",
        laborCost: "",
        completed: false,
      },
      repairs: []
    };
  },
  name: "SubmitRepair",
  methods: {
    addRepair() {
      WorkOrderService.addRepair(this.repair).then((response) => {
        if (response.status === 201 || response.status === 200) {
         
           const repairs = [...this.$store.state.repairs]
           repairs.push(response.data);
           this.$store.commit("SET_REPAIRS", repairs);

          this.repair = {};
        }
      });
    },
  },
};
</script>

<style>
.orderForm {
  text-align: center;
  font-family: "Assistant", Arial, Helvetica, sans-serif;
  font-weight: bold;
  color: hsl(240, 100%, 27%);
}
</style>