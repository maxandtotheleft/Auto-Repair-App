<template>
  <div>
    <form class="orderForm">
      <label>Repair Name</label>
      <input type="text" v-model="this.repair.repairName" />
     <label>Parts Cost</label>
      <input type="text" v-model="this.repair.partsCost" />
      <label>Labor Cost</label>
      <input type="text" v-model="this.repair.laborCost" />
      <label>Completed</label>
      <input type="checkbox" v-model="this.repair.completed" />
      <input type="submit" value="Save" />
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      repair: {
        workOrderId: "",
        repairName: "",
        partsCost: "",
        laborCost: "",
        completed: false,
      },
    };
  },
  name: "SubmitRepair",
  methods: {},
};
</script>

<style>
</style>