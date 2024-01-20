<template>
  <div>
    <App-header></App-header>
    <h1>{{ eventDetails.eventName }}</h1>
    <p>Start Date: {{ eventDetails.eventStart }}</p>
    <p>End Date: {{ eventDetails.eventEnd }}</p>
    <!-- Display schedule here -->
    <h2>Schedule</h2>
    <ul>
      <li v-for="scheduleItem in sortedSchedule" :key="scheduleItem.scheduleId">
        <div class="match-details">
          <!-- Display match type -->
          <span>{{ getMatchType(scheduleItem.matchNumber) }}:</span>
          <!-- Home team info -->
          <div class="team-info" :style="{ color: getTeamColor(scheduleItem, 'home') }">
            <span class="team-name">{{ scheduleItem.homeTeamName }}</span>
            <span class="score">{{ scheduleItem.homeTeamPoints }}</span>
          </div>
          <!-- Away team info -->
          <div class="team-info" :style="{ color: getTeamColor(scheduleItem, 'away') }">
            <span class="score">{{ scheduleItem.awayTeamPoints }}</span>
            <span class="team-name">{{ scheduleItem.awayTeamName }}</span>
          </div>
        </div>
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
  computed: {
    // Computed property to return the schedule sorted by match number
    sortedSchedule() {
      return this.schedule.slice().sort((a, b) => a.scheduleOrder - b.scheduleOrder);
    },
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

<style>
  ul {
    list-style: none;
    padding: 0;
    width: 700px;
  }

  .match-details {
    width: 690px;
    display: flex;
    align-items: center;
    padding: 5px;
    border: 1px solid black;
    justify-content: space-between;
  }

  .team-info {
    display: flex;
    align-items: center;
  }

  .team-name {
    font-weight: bold;
    font-size: 20px;
    margin-right: 10px; /* Adjust as needed */
  }

  .score {
    font-style: bold;
    font-size: 20px;
    font-weight: bold;
    padding: 5px;
    border: 1px solid black;
    color: black;
  }

  h1 {
    padding-top: 25px;
  }

  h2 {
    padding: 15px 15px;
  }

  ul {
    padding: 15px;
  }
</style>