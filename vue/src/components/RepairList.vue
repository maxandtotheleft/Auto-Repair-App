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
        Completed: {{ repair.completed }}
        <span v-if="($store.state.isEmployee) || ($store.state.isAdmin)">
          <input
            class="checker"
            type="checkbox"
            v-model="repair.completed"
            @click="updateRepair(repair)"
          />
        </span>
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
    updateRepair(repair) {
      WorkOrderService.updateRepair(repair.repairItemId, repair);
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