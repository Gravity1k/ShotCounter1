package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Event;

import java.util.List;

public interface EventDTO {

    List<Event> getEvent();

    List<Event> getAllEvents();

    Event getEventById(int id);

    List<Event> getEventByName(String eventName);
}
