<template>
  <div>
    <h2>Repairs</h2>
    <ul>
      <li
        class="repair"
        v-for="repair in $store.state.repairs"
        v-bind:key="repair.id"
      >
        Repair: {{ repair.repairName }}
        <p></p>
        Parts Cost: ${{ repair.partsCost.toFixed(2) }}
        <p></p>
        Labor Cost: ${{ repair.laborCost.toFixed(2) }}
        <p></p>
        <span>
          Completed: {{ repair.completed }}
          <input
            v-if="$store.state.isEmployee || $store.state.isAdmin"
            class="checker"
            type="checkbox"
            v-model="repair.completed"
            v-on:click="updateRepair(repair)"
          />
        </span>

        <!-- <div v-if="($store.state.isEmployee) || ($store.state.isAdmin)">
        <button @click="updateRepair(repair)">Edit</button>
        </div> -->
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
      if (repair.completed == true) {
        repair.completed = false;
      } else if (repair.completed == false) {
        repair.completed = true;
      }
      // const updatedRepair = {
      //   repairItemId: repair.repairItemId,
      //   workOrderId: repair.workOrderId,
      //   repairName: repair.repairName,
      //   partsCost: repair.partsCost,
      //   laborCost: repair.laborCost,
      //   completed: repair.completed
      // };
      WorkOrderService.updateRepair(repair.repairItemId, repair);
    },
  },
  created() {
    
  },
  // deactivated() {
  //   this.$store.state.repairs = [];
  // }
};
</script>

<style>
.repair {
  display: flex;
  flex-direction: column;
  font-family: "Assistant", Arial, Helvetica, sans-serif;
  border: solid 1px black;
  margin: 20px 25px 10px -10px;
  padding: 10px;
  border-radius: 15px 35px;
}
</style>