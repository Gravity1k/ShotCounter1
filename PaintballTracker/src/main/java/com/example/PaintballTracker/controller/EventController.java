package com.example.PaintballTracker.controller;

import com.example.PaintballTracker.dto.EventDTO;
import com.example.PaintballTracker.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventDTO eventDTO;

    @ModelAttribute("allEvents")
    public List<Event> getAllEvents() {
        return eventDTO.getAllEvents();
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvent() {
        List<Event> events = eventDTO.getEvent();
        return events;
    }

    @RequestMapping(path = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        Event event = eventDTO.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/eventsByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventByName(@PathVariable String name) {
        List<Event> events = eventDTO.getEventByName(name);
        if (events != null && !events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
