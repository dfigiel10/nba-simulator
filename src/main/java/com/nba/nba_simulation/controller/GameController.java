package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.repository.GameRepository;
import com.nba.nba_simulation.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto gameDto) {
        GameDto savedGame = gameService.createGame(gameDto);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }

    @PostMapping("/{gameId}/play")
    public ResponseEntity<GameDto> playGame(@PathVariable Long gameId) {
        GameDto playedGame = gameService.playGame(gameId);
        return ResponseEntity.ok(playedGame);
    }

    @GetMapping("/getGame/{gameId}")
    public ResponseEntity<GameDto> getGame(@PathVariable Long gameId) {
        GameDto game = gameService.getGame(gameId);
        return ResponseEntity.ok(game);
    }
}
