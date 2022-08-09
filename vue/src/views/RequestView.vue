<template>
  <div>
    <h1>Requests</h1>
    <request />


    <submit-request /> 
    
  </div>
</template>

<script>
import Request from '../components/Request.vue';
import SubmitRequest from '../components/SubmitRequest.vue'; 

export default {
 // name: '',
  components: {
    Request,
    SubmitRequest
  }
}
</script>