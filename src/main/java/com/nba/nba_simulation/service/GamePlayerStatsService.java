package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import com.nba.nba_simulation.dto.LeadingAssistsDto;
import com.nba.nba_simulation.dto.LeadingReboundsDto;
import com.nba.nba_simulation.dto.LeadingScorerDto;
import com.nba.nba_simulation.entity.GamePlayerStats;

import java.util.List;

public interface GamePlayerStatsService {
    List<GamePlayerStatsDto> getBoxScore(Long gameId);
    List<GamePlayerStatsDto> getPlayerStats(Long playerId);
    List<LeadingScorerDto> topPointsPerGame();
    List<LeadingReboundsDto> topReboundsPerGame();
    List<LeadingAssistsDto> topAssistsPerGame();
}
