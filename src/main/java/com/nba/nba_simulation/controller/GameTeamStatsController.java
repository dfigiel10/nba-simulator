package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.service.GameTeamStatsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/gameTeam")
public class GameTeamStatsController {

    @Autowired
    private GameTeamStatsService gameTeamStatsService;

    @GetMapping("/boxscore/{gameId}/{teamId}")
    public ResponseEntity<GameTeamStatsDto> getBoxscore(Long gameId, Long teamId) {
        GameTeamStatsDto gts = gameTeamStatsService.getBoxscore(gameId, teamId);
        return ResponseEntity.ok(gts);
    }
}
