<template>
  <div>
    <!-- <div v-for="(option, index) in years" v-bind:key="index">
      {{ option }}
    </div> -->
    <label for="year">Year</label>

    <select v-model="vehicle.year">
      <option
        v-for="(option, index) in years.slice().sort()"
        v-bind:key="index"
        :value="option"
      >
        {{ option }}
      </option>
    </select>
    <div>{{ this.vehicle.year }}</div>

    <label for="make">Make</label>

    <select v-model="vehicle.make" v-show="this.makes != ''">
      <option
        v-for="(option, index) in makes.slice().sort()"
        v-bind:key="index"
        :value="option"
      >
        {{ option }}
      </option>
    </select>

    <div>{{ this.vehicle.make }}</div>
    <label for="model">Model</label>
    <select v-model="vehicle.model" v-show="this.models != ''">
      <option
        v-for="(option, index) in models.slice().sort((a, b) => (a.model > b.model) ? 1 : ((b.model > a.model) ? -1 : 0))"
        v-bind:key="index"
        :value="option.model"
      >
        {{ option.model }}
      </option>
    </select>

    <div>{{ this.vehicle.model }}</div>

    <label for="color">Color</label>
    <select v-model="vehicle.color" v-show="this.vehicle.model != ''">
      <option
        v-for="color in colors"
        v-bind:key="color.id"
        :value="color"
      >
        {{ color }}
      </option>
    </select>

    <div>{{ this.vehicle.color }}</div>

    <input class="submitB" type="submit" value="Save" />
  </div>
</template>

<script>
import APIService from "@/services/APIService";

export default {
  name: "AddVehicle",
  data() {
    return {
      vehicle: {
        customerId: this.$store.state.activeCustomer.customerId,
        make: "",
        model: "",
        year: "",
        color: "",
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
      ]
    };
  },
  watch: {
    "vehicle.year": function () {
      APIService.getVehicleMakes().then((response) => {
        this.makes = response.data;
      });
    },
    "vehicle.make": function (){
        APIService.getVehicleModels(this.vehicle.year, this.vehicle.make).then((response) => {
            this.models = response.data;
        })
    }
  },
  created() {
    APIService.getVehicleYears().then((response) => {
      this.years = response.data;
    });
  },
};
</script>

<style>
</style>