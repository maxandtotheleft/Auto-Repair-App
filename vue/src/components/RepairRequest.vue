<template>
  <div>
    <form class="orderForm" @submit="addRepair">
      <label>Repair Name</label>
      <input type="text" v-model="repair.repairName" />
      <p></p>
      <label>Parts Cost</label>
      <input type="text" v-model="repair.partsCost" />
      <p></p>
      <label>Labor Cost</label>
      <input type="text" v-model="repair.laborCost" />
      <p></p>
      <label>Completed</label>
      <input type="checkbox" v-model="repair.completed" />
      <p></p>
      <input type="submit" value="Save" />
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
}
</style>