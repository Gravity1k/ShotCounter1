<template>
  <div>
    <App-header></App-header>
    <h1>{{ eventDetails.eventName }}</h1>
    <p>Start Date: {{ eventDetails.eventStart }}</p>
    <p>End Date: {{ eventDetails.eventEnd }}</p>
    <!-- Display schedule here -->
    <h2>Schedule</h2>
    <ul>
      <li v-for="scheduleItem in schedule" :key="scheduleItem.scheduleId">
        <!-- Display match type, teams, and points -->
        {{ getMatchType(scheduleItem.matchNumber) }}: 
        <span :style="{ color: getTeamColor(scheduleItem, 'home') }">
          {{ scheduleItem.homeTeamName }}
        </span>
        ({{ scheduleItem.homeTeamPoints }}) vs 
        <span :style="{ color: getTeamColor(scheduleItem, 'away') }">
          {{ scheduleItem.awayTeamName }}
        </span>
        ({{ scheduleItem.awayTeamPoints }})
      </li>
    </ul>
    <h2>Team Information</h2>
    <ul>
      <li v-for="teamInfo in teamInformation" :key="teamInfo.teamID">
        {{ teamInfo.teamName }} - Points Won: {{ teamInfo.pointsWon }}, 
        Points Lost: {{ teamInfo.pointsLost }}, Point Spread: {{ teamInfo.pointSpread }}
      </li>
    </ul>
  </div>
</template>

<script>
import AppHeader from './AppHeader.vue';

export default {
  name: 'EventDetails',
  components: {
    AppHeader,
  },
  data() {
    return {
      eventDetails: {},
      schedule: [],
      teamInformation:[],
    };
  },
  methods: {
    getMatchType(matchNumber) {
      switch (matchNumber) {
        case 1:
          return "Prelim";
        case 2:
          return "Quarters";
        case 3:
          return "Semi";
        case 4:
          return "Finals";
        default:
          return "Unknown";
      }
    },
    getTeamColor(scheduleItem, team) {
      const homeScore = scheduleItem.homeTeamPoints;
      const awayScore = scheduleItem.awayTeamPoints;

      if (team === 'home') {
        return homeScore > awayScore ? 'green' : 'red';
      } else if (team === 'away') {
        return awayScore > homeScore ? 'green' : 'red';
      } else {
        return 'black'; // Default color
      }
    },
  },
  mounted() {
  const eventId = this.$route.params.id;

  if (eventId) {
    // Fetch event details based on the ID
    fetch(`http://localhost:8080/events/${eventId}`)
      .then((response) => response.json())
      .then((data) => {
        this.eventDetails = data;
      });

    // Fetch schedule based on the event ID
    fetch(`http://localhost:8080/schedule/${eventId}`)
      .then((response) => response.json())
      .then((data) => {
        // Add matchNumber property to each schedule item
        this.schedule = data.map((scheduleItem) => ({
          ...scheduleItem,
          matchNumber: scheduleItem.matchNumber,
        }));
      });

    // Fetch performance based on the event ID
    fetch(`http://localhost:8080/performance/${eventId}`)
      .then((response) => response.json())
      .then((data) => {
        this.teamInformation = data;
      });
  } else {
    console.error('Event ID is undefined');
  }
},
};
</script>