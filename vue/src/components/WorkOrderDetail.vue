<template>
  <div>
      <form @submit.prevent="updateWorkOrder">
      <h1>Work Order #{{ this.workOrder.workOrderId }}</h1>
      <div>Completed: {{ this.workOrder.allCompleted }}  <input class="checker" type="checkbox" v-model="workOrder.allCompleted" @click="flipCompletedStatus"
        /></div>
      <div>Time Completed: {{ this.workOrder.timeCompleted }} <input type="datetime-local" v-model="workOrder.timeCompleted">
      </div>
      <div>
        Approved: {{ this.workOrder.approved }}
        <input class="checker" type="checkbox" v-model="workOrder.approved" @click="flipApprovedStatus"
        />
      </div>
      <div>
        Paid: {{ this.workOrder.paid }}
        <input class="checker" type="checkbox" v-model="workOrder.paid" @click="flipPaidStatus"
        />
      </div>
      <input  type="submit" value="Save" />
      </form>
  </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";

export default {
  name: "WorkOrderDetails",
  methods: {
    flipApprovedStatus() {
      if (this.workOrder.approved == true) {
        this.workOrder.approved = false;
      } else if (this.workOrder.approved == false) {
        this.workOrder.approved = true;
      }
      
    },
    flipPaidStatus() {
      if (this.workOrder.paid == true) {
        this.workOrder.paid = false;
      } else if (this.workOrder.paid == false) {
        this.workOrder.paid = true;
      }
    
    },
    flipCompletedStatus() {
      if (this.workOrder.allCompleted == true) {
        this.workOrder.allCompleted = false;
      } else if (this.workOrder.allCompleted == false) {
        this.workOrder.allCompleted = true;
      }
    
    },
    updateWorkOrder(){

        WorkOrderService.updateWorkOrder(
        this.workOrder.workOrderId,
        this.workOrder
      );
    }
  },
  data() {
    return {
      workOrder: {
        workOrderId: "",
        requestId: "",
        allCompleted: "",
        timeCompleted: "",
        approved: "",
        paid: "",
      },
    };
  },
  created() {
    WorkOrderService.getWorkOrders().then((response) => {
      this.workOrder = response.data.find(
        (element) => element.workOrderId === this.$route.params.id
      );
    });
  },
};
</script>

<style>
</style>