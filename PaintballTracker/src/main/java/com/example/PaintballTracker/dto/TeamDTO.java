package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Team;

import java.util.List;

public interface TeamDTO {

    List<Team> getTeam();

    List<Team> getAllTeams();

    Team getTeamById(int id);
}


