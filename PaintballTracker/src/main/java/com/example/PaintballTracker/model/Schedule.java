package com.example.PaintballTracker.model;

public class Schedule {
    private String awayTeamName;
    private int scheduleId;
    private int eventId;
    private int homeTeamId;
    private int awayTeamId;
    private String homeTeamName;
    private int pointsWon;
    private int pointsLost;
    private int eventPosition;
    private int scheduleOrder;
    private int matchNumber;
    private int homeTeamPoints;
    private int awayTeamPoints;

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(int homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(int awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getHomeTeamName() {

        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getPointsWon(){
        return pointsWon;
    }

    public int getPointsLost(){
        return pointsLost;
    }

    public void setPointsLost(int pointsLost){
        this.pointsLost = pointsLost;
    }

    public void setPointsWon(int pointsWon){
        this.pointsWon = pointsWon;
    }
    public int getEventPosition(){
        return eventPosition;
    }
    public void setEventPosition(int eventPosition){
        this.eventPosition = eventPosition;
    }
    public int getScheduleOrder(){
        return scheduleOrder;
    }
    public void setScheduleOrder(int scheduleOrder){
        this.scheduleOrder = scheduleOrder;
    }

    public int getMatchNumber(){
        return matchNumber;
    }
    public void setMatchNumber(int matchNumber){
        this.matchNumber = matchNumber;
    }

}
