package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcScheduleDTO implements ScheduleDTO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcScheduleDTO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getScheduleByEventId(int eventId) {
        List<Schedule> scheduleList = new ArrayList<>();
        String sql = "SELECT\n" +
                "  schedule.*, \n" +
                "  home_team.team_name AS home_team_name, \n" +
                "  away_team.team_name AS away_team_name \n" +
                "FROM\n" +
                "  schedule \n" +
                "JOIN\n" +
                "  team AS home_team ON schedule.home_team_id = home_team.team_id \n" +
                "JOIN\n" +
                "  team AS away_team ON schedule.away_team_id = away_team.team_id \n" +
                "WHERE\n" +
                "  schedule.event_id = ? \n" +
                "ORDER BY\n" +
                "  schedule.match_order ASC;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, eventId);

        while (result.next()) {
            Schedule schedule = new Schedule();
            schedule.setScheduleId(result.getInt("schedule_id"));
            schedule.setEventId(result.getInt("event_id"));
            schedule.setHomeTeamId(result.getInt("home_team_id"));
            schedule.setAwayTeamId(result.getInt("away_team_id"));
            schedule.setHomeTeamName(result.getString("home_team_name"));
            schedule.setAwayTeamName(result.getString("away_team_name"));
            schedule.setScheduleOrder(result.getInt("match_order"));
            schedule.setMatchNumber(result.getInt("match_number"));
            schedule.setAwayTeamPoints(result.getInt("away_team_points"));
            schedule.setHomeTeamPoints(result.getInt("home_team_points"));
            scheduleList.add(schedule);
        }

        return scheduleList;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return null;
    }


}