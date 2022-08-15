<template>
  <div>
    <ul>
      <li
        class="repair"
        v-for="repair in this.$store.state.repairs"
        v-bind:key="repair.id"
      >
        Repair: {{ repair.repairName }}
        <p></p>
        Parts Cost: {{ repair.partsCost }}
        <p></p>
        Labor Cost: {{ repair.laborCost }}
        <p></p>
        Completed: {{ repair.Completed }}
        <input
          class="checker"
          type="checkbox"
          v-model="repair.completed"
        />
        <!-- dont forget to put @ click back-->
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
      // repair: {
      //   workOrderId: this.$route.params.id,
      //   repairId: "",
      //   repairName: "",
      //   partsCost: "",
      //   laborCost: "",
      //   completed: false,
      // },
    };
  },
  methods: {
    updateRepair() {
      WorkOrderService.updateRepair(this.repair.repairId, this.repair);
    },
  },
  created() {
    WorkOrderService.getRepairsByWorkOrderId(this.$route.params.id).then(
      (response) => {
        this.$store.commit("SET_REPAIRS", response.data);
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