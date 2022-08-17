<template>
  <div class="requests">
    <div  v-for="request in this.$store.state.requests" v-bind:key="request.id">
      <router-link :to="{ name: 'workOrderView', params: {id: request.requestId} }">{{request.description}}</router-link>
    </div>
  </div>
</template>

<script>
import RequestService from "@/services/RequestService";

export default {
  name: "Request",
  created() {
    
    RequestService.getAllRequests(this.$store.state.user.id).then((response) => {
        this.$store.commit("SET_REQUESTS", response.data);
    });
  },
};
</script>

<style>

</style>