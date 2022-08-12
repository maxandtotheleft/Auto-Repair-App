<template>
  <div>
    <div v-for="(option, index) in years" v-bind:key="index">
      {{ option }}
    </div>
    <!-- <label for="Make">Make</label>
    
    <select>
      <option v-for="(option, index) in makes" v-bind:key="index" :value="this.option">
        {{ option }}
      </option>
    </select> -->

    <input class="submitB" type="submit" value="Save" />
  </div>
</template>

<script>
import axios from "axios";

const options = {
  method: "GET",
  url: "https://car-data.p.rapidapi.com/cars/years",
  headers: {
    "X-RapidAPI-Key": "3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1",
    "X-RapidAPI-Host": "car-data.p.rapidapi.com",
  },
};

export default {
  name: "AddVehicle",
  data() {
    return {
      years: [],
    };
  },
  created() {
    axios.request(options).then((response) => {
      this.years = response.data;
    });
  },
};
</script>

<style>
</style>