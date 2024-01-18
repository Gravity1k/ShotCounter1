package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Performance;

import java.util.List;

public interface PerformanceDTO {

    List<Performance> getPerformances(int eventId);
}
