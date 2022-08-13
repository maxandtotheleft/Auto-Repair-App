<template>
  <div>
    <!-- <div v-for="(option, index) in years" v-bind:key="index">
      {{ option }}
    </div> -->
    <label for="year">Year</label>

    <select v-model='this.vehicle.year'>
      <option
        v-for="(option, index) in years.sort()"
        v-bind:key="index"
        :value="option"
      >
        {{ option }}
      </option>
    </select>

    <input class="submitB" type="submit" value="Save" />
  </div>
</template>

<script>
// import APIService from '@/services/APIService'
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
      vehicle: {
        customerId: this.$store.state.activeCustomer.customerId,
        make: "Honda",
        model: "Fit",
        year: "",
        color: "Blue",
      },
      makes: [],
      models: [],
      years: [],
      colors: [
        "Black",
        "Blue",
        "Brown",
        "Gold",
        "Gray",
        "Green",
        "Orange",
        "Purple",
        "Red",
        "Silver",
        "Tan",
        "White",
        "Yellow",
      ],
    };
  },
  created() {
    axios.request(options).then((response) => {
      this.years = response.data;
    });
    // this.years = APIService.getVehicleYears();
  },
};
</script>

<style>
</style>