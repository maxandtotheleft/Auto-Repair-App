<template>
  <div class="big">
    <div class="container">
    
      <div class="logo"><img src="@/assets/carlogo1.png" /></div>
    </div>

    <div class="container2"></div>
  </div>
</template>
<script>
export default {
  name: "heading",
};
</script>


<style>
.big {
  display: flex;
  width: 100%;
border-radius: 25% 10%;

}
.container {
  display: flex;
  background: linear-gradient(0deg, black, gray 40%, gray);
  width: 50%;
  float: left;
}

.container2 {
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  background-repeat: no-repeat;
  display: flex;
  width: 50%;
  float: right;
}

.logo {
  width: 50%;
  margin: 10px 20px 10px 20px;
}
</style>