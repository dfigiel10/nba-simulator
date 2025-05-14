package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nba.nba_simulation.service.GamePlayerStatsService;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/gamePlayerStats")
public class GamePlayerStatsController {

    @Autowired
    private GamePlayerStatsService gamePlayerStatsService;

    @GetMapping("/{gameId}")
    public ResponseEntity<List<GamePlayerStatsDto>> getBoxScore(@PathVariable Long gameId) {
        List<GamePlayerStatsDto> boxScore = gamePlayerStatsService.getBoxScore(gameId);
        return new ResponseEntity<>(boxScore, HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<GamePlayerStatsDto>> getPlayerStats(@PathVariable Long playerId) {
        List<GamePlayerStatsDto> playerStats = gamePlayerStatsService.getPlayerStats(playerId);
        return new ResponseEntity<>(playerStats, HttpStatus.OK);
    }
}
