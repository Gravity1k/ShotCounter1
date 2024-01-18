package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Component
public class jdbcEventDTO implements EventDTO {
    private final JdbcTemplate jdbcTemplate;

    public jdbcEventDTO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Event> getEvent() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Event event = new Event();
            event.setEventName(result.getString("event_name"));
            event.setEventID(result.getInt("event_id"));
            Date eventStart = result.getDate("start_date");
            Date eventEnd = result.getDate("end_date");
            event.setEventStart(eventStart);
            event.setEventEnd(eventEnd);
            events.add(event);
        }
        return events;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Event event = new Event();
            event.setEventName(result.getString("event_name"));
            event.setEventID(result.getInt("event_id"));
            Date eventStart = result.getDate("start_date");
            Date eventEnd = result.getDate("end_date");
            event.setEventStart(eventStart);
            event.setEventEnd(eventEnd);
            events.add(event);
        }
        return events;
    }


    @Override
    public Event getEventById ( int eventId){
        String sql = "SELECT * FROM event WHERE event_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, eventId);
        Event event = null;
        if (result.next()) {
            event = new Event();
            event.setEventName(result.getString("event_name"));
            event.setEventID(result.getInt("event_id"));
            Date eventStart = result.getDate("start_date");
            Date eventEnd = result.getDate("end_date");
            event.setEventStart(eventStart);
            event.setEventEnd(eventEnd);
        }
            return event;
    }


    @Override
    public List<Event> getEventByName(String eventName) {
        String sql = "SELECT * FROM event WHERE event_name LIKE ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, "%" + eventName + "%");

        List<Event> events = new ArrayList<>();

        while (result.next()) {
            Event event = new Event();
            event.setEventName(result.getString("event_name"));
            event.setEventID(result.getInt("event_id"));
            Date eventStart = result.getDate("start_date");
            Date eventEnd = result.getDate("end_date");
            event.setEventStart(eventStart);
            event.setEventEnd(eventEnd);

            events.add(event);
        }

        return events;
    }
}


