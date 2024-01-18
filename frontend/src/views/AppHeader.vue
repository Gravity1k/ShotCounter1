<template>
    <div class="container">
    <div class="logo">
      <img src="../pictures/ShotCounterLOGO.png" alt="Logo" class="logo-img">
      <div class="navbar">
        <ul>
          <router-link to="/">
            <li>Home</li>
          </router-link>
          <li><a href="#">Events</a></li>
          <li><a href="#">Blog</a></li>
        </ul>
      </div>
    </div>
    </div>
</template>
<style>
.container {
  position: relative;
  height: 80px;
}

.logo-img {
  width: 400px;
  position: absolute;
  top: 0;
  left: 10px;
  z-index: 998;
}

.imgcontainer {
  position: absolute;
  top: 38.6%;
  right: 5%;
  transform: translateY(-50%); 
  z-index: 999;
  right: 135px;
  bottom: 10px
}

.logo-img1 {
  transform: scaleX(-1);
  width: 700px; 
}

.navbar {
  height: 90px;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  display: grid;
  background: rgb(30, 160, 247);
  place-items: center;
}

.navbar ul{
  list-style: none;
  display: flex;
  flex-direction: row;
  z-index: 1;
}

.navbar ul li{
  font-size: 20px;
  margin: 0 45px;
  z-index: 1;
}


.navbar ul li a{
  text-decoration: none;
  color: black;
}

.navbar ul li a:hover{
  color: rgb(255, 255, 255)
}
</style>