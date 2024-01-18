package com.example.PaintballTracker.model;

public class Team {
    private String teamName;

    public Team(){}

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeam() {
        return teamName;
    }

    public void setTeam(String teamName) {
        this.teamName = teamName;
    }

}