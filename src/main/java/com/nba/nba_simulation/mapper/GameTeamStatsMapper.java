package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.GameTeamStats;
import com.nba.nba_simulation.entity.Team;

public class GameTeamStatsMapper {

    public static GameTeamStatsDto mapToGameTeamStatsDto(GameTeamStats gameTeamStats) {
        GameTeamStatsDto dto = new GameTeamStatsDto();
        dto.setId(gameTeamStats.getId());
        dto.setGameId(gameTeamStats.getGame().getId());
        dto.setTeamId(gameTeamStats.getTeam().getId());
        dto.setPoints(gameTeamStats.getPoints());
        dto.setRebounds(gameTeamStats.getRebounds());
        dto.setAssists(gameTeamStats.getAssists());
        return dto;
    }

    public static GameTeamStats mapToGameTeamStats(GameTeamStatsDto gameTeamStatsDto, Game game, Team team) {
        GameTeamStats stats = new GameTeamStats();
        stats.setId(gameTeamStatsDto.getId());
        stats.setTeam(team);
        stats.setGame(game);
        stats.setPoints(gameTeamStatsDto.getPoints());
        stats.setRebounds(gameTeamStatsDto.getRebounds());
        stats.setAssists(gameTeamStatsDto.getAssists());
        return stats;
    }

}
