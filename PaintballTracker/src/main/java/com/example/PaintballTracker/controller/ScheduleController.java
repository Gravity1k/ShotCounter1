package com.example.PaintballTracker.controller;

import com.example.PaintballTracker.dto.ScheduleDTO;
import com.example.PaintballTracker.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleDTO scheduleDTO;

    @GetMapping("/allSchedules")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleDTO.getAllSchedules();
        if (!schedules.isEmpty()) {
            return ResponseEntity.ok(schedules);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Schedule>> getScheduleByEventId(@PathVariable int eventId) {
        List<Schedule> schedule = scheduleDTO.getScheduleByEventId(eventId);
        if (!schedule.isEmpty()) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/eventDetails/{eventId}")
    public ResponseEntity<List<Schedule>> getEventDetails(@PathVariable int eventId) {
        List<Schedule> schedule = scheduleDTO.getScheduleByEventId(eventId);
        if (!schedule.isEmpty()) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

