package com.example.PaintballTracker.model;

public class Performance {

    private int pointsWon;
    private int pointsLost;
    private int pointSpread;
    private int teamID;
    private int eventID;
    private int performanceID;

    public int getPointsWon() {
        return pointsWon;
    }

    public void setPointsWon(int pointsWon) {
        this.pointsWon = pointsWon;
    }

    public int getPointsLost() {
        return pointsLost;
    }

    public void setPointsLost(int pointsLost) {
        this.pointsLost = pointsLost;
    }


    public int getPointSpread() {
        return pointSpread;
    }

    public void setPointSpread(int pointSpread) {
        this.pointSpread = pointSpread;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceID(int performanceID) {
        this.performanceID = performanceID;
    }

}
