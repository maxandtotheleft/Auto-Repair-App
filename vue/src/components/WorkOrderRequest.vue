<template>
    <div>
    <form class="orderForm">

      <label >TIME COMPLETED</label>
     <input type="datetime-local" v-model="this.workOrder.timeCompleted">
     
     

      <input  type="submit" value="Save" />
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      workOrder: {
        employeeId: this.$store.state.activeEmployee.employeeId,
       allCompleted: false,
       timeCompleted: "",
      },
    };
  },
  name: "SubmitWorkOrder",
  methods: {
  
  },

};

</script>

<style>

</style>