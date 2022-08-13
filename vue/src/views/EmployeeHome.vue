<template>
  <div>
    <heading />
    <div class="greeting">
      Hello {{ this.$store.state.user.firstName }}
    </div>
    <div class="greeting">
      Your Employee ID is: {{ this.$store.state.activeEmployee.employeeId }}
    </div>
    <div class="work-order">
      <router-link :to="{ name: 'WorkOrders' }">View Work Orders</router-link>
    </div>
    <router-link
      :to="{ name: 'registerEmployee' }"
      v-if="
        this.$store.state.user.authorities.some(
          (authority) => authority.name === 'ROLE_ADMIN'
        )
      "
      >Register an Employee</router-link
    >
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";
import RequestService from "@/services/RequestService";

export default {
  name: "employee-home",
  components: {
    Heading,
  },
  created() {
    RequestService.getEmployeeByUserId(this.$store.state.user.id).then(
      (response) => {
        this.$store.commit("SET_EMPLOYEE", response.data);
      }
    );
  },
};
</script>

<style>
.work-order {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  /* margin: left;  */
  margin: auto;
  /* margin: 20 0 0 450px;   */
  padding: 25px;
  margin-top: 25px;
}
.greeting {
  font-family: Arial, Helvetica, sans-serif;
  background: rgb(255, 255, 255);
  border: 0px solid rgb(184, 176, 176);
  border-radius: 15px 35px;
  text-align: center;
  width: 400px;
  height: auto;
  overflow: hidden;
  /* margin: left;  */
  margin: auto;
  /* margin: 20 0 0 450px;   */
  padding: 25px;
  margin-top: 25px;
}
</style>