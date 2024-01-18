package com.example.PaintballTracker.controller;
import com.example.PaintballTracker.dto.TeamDTO;
import com.example.PaintballTracker.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class TeamController {
    @Autowired
    private TeamDTO teamDTO;


    @ModelAttribute("allTeams")
    public List<Team> getAllTeams() {
        return teamDTO.getAllTeams();
    }

    @RequestMapping(path = "/team", method = RequestMethod.GET)
    public List<Team> getTeam() {
        List<Team> teams = teamDTO.getTeam();
        return teams;
    }

    @RequestMapping(path = "/team/{id}", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeamById(@PathVariable int id) {
        Team team = teamDTO.getTeamById(id);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
