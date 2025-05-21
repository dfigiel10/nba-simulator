package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Schedule;

public interface GameService {
    GameDto createGame(GameDto gameDto);
    GameDto playGame(Long gameId);
    Game createGame(GameDto gameDto, Schedule schedule);
}
