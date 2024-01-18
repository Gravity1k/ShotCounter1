package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Performance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcPerformanceDTO implements PerformanceDTO {

    private final JdbcTemplate jdbcTemplate;

    public jdbcPerformanceDTO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Performance> getPerformances(int eventId) {
        List<Performance> performanceList = new ArrayList<>();
        String sql = "SELECT * FROM performance WHERE event_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, eventId);

        while (result.next()) {
            Performance performance = new Performance();
            performance.setPointsWon(result.getInt("points_won"));
            performance.setPointsLost(result.getInt("points_lost"));
            performance.setPointSpread(result.getInt("point_spread"));
            performance.setTeamID(result.getInt("team_id"));
            performance.setEventID(result.getInt("event_id"));
            performance.setPerformanceID(result.getInt("performance_id"));

            performanceList.add(performance);
        }

        return performanceList;
    }
}
