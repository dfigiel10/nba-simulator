package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.GameTeamStatsDto;

public interface GameTeamStatsService {
    GameTeamStatsDto getBoxscore(Long gameId, Long teamId);
}
