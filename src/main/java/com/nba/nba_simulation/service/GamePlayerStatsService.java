package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import com.nba.nba_simulation.entity.GamePlayerStats;

import java.util.List;

public interface GamePlayerStatsService {
    List<GamePlayerStatsDto> getBoxScore(Long gameId);
    List<GamePlayerStatsDto> getPlayerStats(Long playerId);
    List<GamePlayerStatsDto> topPointsPerGame();
    List<GamePlayerStatsDto> topReboundsPerGame();
    List<GamePlayerStatsDto> topAssistsPerGame();
}
