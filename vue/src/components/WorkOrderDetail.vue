<template>
  <div>
      <form @submit.prevent="updateWorkOrder">
      <h1>Work Order #{{ this.workOrder.workOrderId }}</h1>
      <div><span class="repBold">Completed:</span> {{ this.workOrder.allCompleted }}
        <span v-if="($store.state.isEmployee) || ($store.state.isAdmin)">  
          <input class="checker" type="checkbox" v-model="workOrder.allCompleted" @click="flipCompletedStatus" />
        </span>
      </div>
      <div v-if="($store.state.isEmployee) || ($store.state.isAdmin) || (this.workOrder.timeCompleted) "><span class="repBold">Pick-up Time:</span> {{ displayDate(this.workOrder.timeCompleted)}}
        <span v-if="($store.state.isEmployee) || ($store.state.isAdmin)">
          <input type="datetime-local" v-model="workOrder.timeCompleted">
        </span>
      </div>
      <div>
        <span class="repBold">Approved:</span> {{ this.workOrder.approved }}
        <span v-if="$store.state.isCustomer">
          <input class="checker" type="checkbox" v-model="workOrder.approved" @click="flipApprovedStatus" />
        </span>
      </div>
      <div v-if="totalCost() > 0">
        <span class="repBold">Total Cost:</span> ${{totalCost().toFixed(2)}}
      </div>
      <div>
        <span class="repBold">Paid:</span> {{ this.workOrder.paid }}
        <span v-if="(($store.state.isEmployee) || ($store.state.isAdmin) ) && (this.workOrder.approved)">
          <input class="checker" type="checkbox" v-model="workOrder.paid" @click="flipPaidStatus"/>
        </span>
      </div>
      <input class="buttonstyle" type="submit" value="Save" />
      </form>
  </div>
</template>

<script>
import WorkOrderService from "@/services/WorkOrderService";

export default {
  name: "WorkOrderDetails",
  methods: {
    displayDate(timestamp) {
      if (timestamp) {
        return new Date(timestamp).toLocaleString();
      }
    },
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
        WorkOrderService.updateWorkOrder(this.workOrder.workOrderId, this.workOrder);
        if (this.$store.state.isCustomer) {
          this.$router.push({name: "requests"});
        } else {
          this.$router.push({name: "WorkOrders"});
        }
    },
    totalCost() {
      let total = 0;
      this.$store.state.repairs.forEach(repair =>
        total += (repair.partsCost + repair.laborCost)
      );

      return total;
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
    this.workOrder = this.$store.state.workOrders.find(element => element.workOrderId === this.$route.params.id)
  },
};
</script>

<style>
</style>