package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @PostMapping("/createTeam")
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        TeamDto savedTeam = teamService.createTeam(teamDto);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long teamId) {
        TeamDto team = teamService.getTeam(teamId);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }
}
