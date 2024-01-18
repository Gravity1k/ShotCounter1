<template>
  <AppHeader></AppHeader>
  
  <div class="imgcontainer">
    <img src="../pictures/ShotCounterFrontPage.png" alt="Logo" class="logo-img1">
  </div>
  <div class="video-container">
    <video autoplay loop muted>
      <source src="../pictures/HomePage.mp4" type="video/mp4">
      Your browser does not support the video tag.
    </video>
    <div class="content">
      <h1>STAT TRACKING</h1>
      <h2>For NXL</h2>
    </div>
  </div>
  <div class="Teamstuff">
    <h1>Team</h1>
    <ul class="team-list">
      <li v-for="(teamName, index) in teams" :key="index">{{ teamName }}</li>
    </ul>
  </div>
  <div class="ListContainer">
    <h1>Events</h1>
    <div class="EventListCard">
      <div class="EventList">
        <ul class="event-list">
          <li v-for="(event, index) in events" :key="index">
            <router-link :to="{ name: 'EventDetails', params: { id: event.id }}">
              <strong @click="showEventDetails(event)">{{ event.eventName }}</strong>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <div v-if="selectedEvent">
    <EventDetails :event="selectedEvent" />
  </div>
  <div class="horizontal-line"></div>
</template>

<script>
import AppHeader from './AppHeader.vue';
import EventDetails from './EventDetails.vue';
export default {
  name: 'HelloWorld',
  components: {
    AppHeader,
    EventDetails,
  },
  data() {
    return {
      teams: [],
      events: [],
      selectedEvent: null,
    };
  },
  methods: {
    showEventDetails(event) {
      this.selectedEvent = event;
    },
  },
  mounted() {
  // Fetch teams
  fetch("http://localhost:8080/team")
    .then((response) => response.json())
    .then((data) => {  
      this.teams = data.map((item) => item.team);
    });

  // Fetch events
  fetch("http://localhost:8080/events")  
    .then((response) => response.json())
    .then((data) => {
      // Reverse the array before mapping
      this.events = data.reverse().map((event) => ({
        id: event.eventID,
        eventName: event.eventName,
      })).sort((a, b) => new Date(b.eventStart) - new Date(a.eventStart));
    });
}
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Fauna+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik+Glitch&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Anton&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Anton&family=Bevan:ital@1&display=swap');

.horizontal-line {
  position: absolute;
  width: 100%;
  height: 4px; 
  background-color: #000; 
  top: 63.27%; 
  transform: translateY(-50%);
  z-index: 997;
  box-shadow: 0 4px 6px rgba(27, 27, 27, 0.89);
}

*{
  margin: 0;
}

.video-container {
  width: 1500px;
  height: 600px;
  position: absolute;
  left: 5%;
  top: 12%;
}

video{
  width: 90%;
  height: 90%;
}
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


.content {
  position: absolute;
  top: 51%; /* Center vertically */
  left: 50%; /* Center horizontally */
  transform: translate(-52%, -50%); /* Center using transform */
  z-index: 996;
  color: black;
  background: rgb(255, 255, 255);
  mix-blend-mode: screen;
  padding-top: 120px;
  padding-bottom: 190px;
  font-family: 'Bevan', sans-serif;
  padding-left: 150px;
  padding-right: 80px;
  width: 1110px;
}

.content h1{
  font-size: 90px;
  color: black;
  font-weight: 1000;
}

.content h2{
  font-size: 90px;
  color: black;
  font-weight: 1000;
  margin-top: 20px;
}

.Teamstuff {
  position: absolute;
  left: 240px;
  top: 600px;
  z-index: 998;
}
.ListContainer {
  position: relative;
  top: 550px;
  left: 1120px;
  width: 480px;
  height: 1290px;
  z-index: 999;
}

.ListContainer h1{
  text-align: center;
  font-family:'Bevan', sans-serif;
  font-size: 50px;
}

.EventListCard {
  background: rgba(255, 255, 255, 0.31);
  border-radius: 4px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(7.3px);
  -webkit-backdrop-filter: blur(7.3px);
  border: 2px solid rgba(0, 0, 0, 0.767);
  box-shadow: -4px 10px 6px rgba(27, 27, 27, 0.89);
  overflow: hidden; 
}

.EventList {
  padding: 8px; 
  overflow-y:auto ;
  height: 710px;
}

/* Add styles for the EventList header */
.EventList h1 {
  font-size: 50px;
  font-weight: bold;
  margin-bottom: 15px;
  text-align: center;
}

.EventList ul li {
  position: relative;
  left: 0;
  color: #000000;
  list-style: none;
  white-space: nowrap;
  margin: 4px 0;
  border-left: 3px solid rgb(30, 160, 247);
  transition: 0.5s;
  cursor: pointer;
  margin-bottom: 9.6px;
  padding-left: 10px; /* Adjust the left padding as needed */
}

.EventList ul li:hover {
  left: 8px;
  background: #4744458a; /* Add background color on hover */
}

.EventList ul li:before {
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  transform: scaleX(0);
  transform-origin: left;
  transition: 0.5s;
}

.EventList ul li:hover:before {
  transform: scaleX(1);
  z-index: -1;
}

.EventList ul {
  list-style: none;
  margin: 0;
  font-size: 20px;
  text-align: left;
  flex-direction: column-reverse;
  padding-left: 0px;
  width: 95%;
}

.EventList ul li a {
  text-decoration: none; /* Remove underline */
  color: black; /* Set the desired text color */
}

.EventList ul li a:visited {
  color: black; /* Set the color for visited links */
}

.EventList::-webkit-scrollbar {
  width: 8px; /* Set the width of the scrollbar */
}

/* Handle */
.EventList::-webkit-scrollbar-thumb {
  background-color: #00000086;; /* Set the color of the scrollbar handle */
  border-radius: 6px; /* Set the radius of the scrollbar handle */
}

/* Track */
.EventList::-webkit-scrollbar-track {
  background-color: #e0e0e0; /* Set the color of the scrollbar track */
}

/* Handle on hover */
.EventList::-webkit-scrollbar-thumb:hover {
  background-color: #00000086; /* Set the color of the scrollbar handle on hover */
}
</style>