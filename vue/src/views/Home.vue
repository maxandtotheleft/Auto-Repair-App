<template>
  <div class="home">
    <heading />
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import Heading from "@/components/Heading.vue";

export default {
  name: "home",

  components: {
    Heading
  },
};
</script>
