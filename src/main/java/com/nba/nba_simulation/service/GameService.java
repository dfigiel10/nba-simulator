package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.GameDto;

public interface GameService {
    GameDto createGame(GameDto gameDto);
}
