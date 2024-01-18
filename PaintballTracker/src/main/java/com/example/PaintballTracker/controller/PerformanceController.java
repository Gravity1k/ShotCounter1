package com.example.PaintballTracker.controller;

import com.example.PaintballTracker.dto.PerformanceDTO;
import com.example.PaintballTracker.model.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceDTO performanceDTO;

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Performance>> getPerformances(@PathVariable int eventId) {
        List<Performance> performances = performanceDTO.getPerformances(eventId);
        if (!performances.isEmpty()) {
            return ResponseEntity.ok(performances);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
