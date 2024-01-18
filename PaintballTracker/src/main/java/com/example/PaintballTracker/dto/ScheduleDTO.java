package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Schedule;

import java.util.List;

public interface ScheduleDTO {
    List<Schedule> getScheduleByEventId(int eventId);

    List<Schedule> getAllSchedules();
}