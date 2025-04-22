package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.GameTeamStats;
import com.nba.nba_simulation.entity.GamePlayerStats;
import com.nba.nba_simulation.dto.GamePlayerStatsDto;

public class GamePlayerStatsMapper {
    public static GamePlayerStatsDto mapToGameTeamStatsDto(GamePlayerStats gamePlayerStats) {
        GamePlayerStatsDto dto = new GamePlayerStatsDto();
        dto.setId(gamePlayerStats.getId());
        dto.setGameId(gamePlayerStats.getGame().getId());
        dto.setPlayerId(gamePlayerStats.getPlayer().getId());
        dto.setPoints(gamePlayerStats.getPoints());
        dto.setRebounds(gamePlayerStats.getRebounds());
        dto.setAssists(gamePlayerStats.getAssists());
        return dto;
    }
}
