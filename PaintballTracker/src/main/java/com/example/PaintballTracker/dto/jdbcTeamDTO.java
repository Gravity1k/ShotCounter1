package com.example.PaintballTracker.dto;
import com.example.PaintballTracker.model.Team;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class jdbcTeamDTO implements TeamDTO {
    private final JdbcTemplate jdbcTemplate;

    public jdbcTeamDTO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Team> getTeam() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Team team = new Team();
            team.setTeam(result.getString("team_name"));
            teams.add(team);
        }
        return teams;
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> allTeams = new ArrayList<>();
        String sql = "SELECT * FROM team";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Team team = new Team();
            team.setTeam(result.getString("team_name"));
            allTeams.add(team);
        }
        return allTeams;
    }

    @Override
    public Team getTeamById(int id) {
        String sql = "SELECT * FROM team WHERE team_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            Team team = new Team();
            team.setTeam(result.getString("team_name"));
            return team;
        }
        return null;
    }
}
