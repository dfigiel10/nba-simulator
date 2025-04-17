package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.PlayerTeamDto;
import com.nba.nba_simulation.dto.PlayerTeamRequest;
import com.nba.nba_simulation.entity.PlayerTeam;
import com.nba.nba_simulation.service.PlayerTeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/playerTeam")
public class PlayerTeamController {
    @Autowired
    PlayerTeamService playerTeamService;

    @PostMapping("/assignTeam")
    public ResponseEntity<PlayerTeamDto> assignPlayerToTeam(@RequestBody PlayerTeamRequest playerTeamRequest) {
        PlayerTeamDto assigned = playerTeamService.assignPlayerToTeam(playerTeamRequest.getPlayerId(), playerTeamRequest.getTeamId());
        return new ResponseEntity<>(assigned, HttpStatus.CREATED);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<List<PlayerTeamDto>> getPlayerTeamHistory(@PathVariable Long playerId) {
        List<PlayerTeamDto> player = playerTeamService.getPlayerTeamHistory(playerId);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
