package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import com.nba.nba_simulation.dto.LeadingAssistsDto;
import com.nba.nba_simulation.dto.LeadingReboundsDto;
import com.nba.nba_simulation.dto.LeadingScorerDto;
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

    @GetMapping("/player/leadingPPG")
    public ResponseEntity<List<LeadingScorerDto>> getLeadingPPG() {
        List<LeadingScorerDto> leadingPPG = gamePlayerStatsService.topPointsPerGame();
        return new ResponseEntity<>(leadingPPG, HttpStatus.OK);
    }

    @GetMapping("/player/leadingAPG")
    public ResponseEntity<List<LeadingAssistsDto>> getLeadingAPG() {
        List<LeadingAssistsDto> leadingAPG = gamePlayerStatsService.topAssistsPerGame();
        return new ResponseEntity<>(leadingAPG, HttpStatus.OK);
    }

    @GetMapping("/player/leadingRPG")
    public ResponseEntity<List<LeadingReboundsDto>> getLeadingRPG() {
        List<LeadingReboundsDto> leadingRPG = gamePlayerStatsService.topReboundsPerGame();
        return new ResponseEntity<>(leadingRPG, HttpStatus.OK);
    }
}

