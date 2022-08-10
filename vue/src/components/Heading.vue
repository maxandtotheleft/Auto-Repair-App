<template>
  <div class="big">
    <div class="container">
      <div class="logo"><img src="@/assets/AAMKLogoBlue.png" /></div>
    </div>

    <div class="container2">
      <div class="hours">
        <p>Operating Hours</p>
        <p>Monday-Friday | 8am-5pm</p>
        <p>Saturday | 10am-4pm</p>
        <p>Sunday | Closed</p>
        <p>Holiday Hours May Vary</p>
      </div>
    </div>
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
  /* border: solid 2px black; */
}
.hours {
  height: 200px;
  width: 400px;
  background: linear-gradient(
    45deg,
    black,
    gray 80%,
    gray,
    grey 80%,
    black
  );
  color: #fff;
  padding: 10px 0px 0px 10px;

  margin: 40px 0px 0px 35px;
  text-align: center;
  /* text-align: left;
  white-space: pre-wrap;
    */
  border: solid 0px black;
  border-radius: 5px;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
}
.container {
  display: flex;
  background: linear-gradient(0deg, black, gray 40%, gray);
  width: 40%;
  float: left;
}

.container2 {
  background-image: url("https://images.unsplash.com/photo-1486262715619-67b85e0b08d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80");
  background-repeat: no-repeat;
  display: flex;
  width: 60%;
  float: right;
  justify-content: center;
}

.logo {
  margin: 35px;
}

.text-center {
  width: 200px;
}
</style>