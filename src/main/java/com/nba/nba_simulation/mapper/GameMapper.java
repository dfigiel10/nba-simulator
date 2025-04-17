package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.GameTeamStats;
import com.nba.nba_simulation.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameMapper {

    public static Game mapToGame(GameDto gameDto, Team homeTeam, Team awayTeam, Team winningTeam, Map<Long, Team> teamMap) {
        Game game = new Game();
        game.setId(gameDto.getId());
        game.setHomeTeam(homeTeam);
        game.setAwayTeam(awayTeam);
        game.setHomeScore(gameDto.getHomeScore());
        game.setAwayScore(gameDto.getAwayScore());
        game.setWinningTeam(winningTeam);
        List<GameTeamStats> gameTeamStats = new ArrayList<>();
        for (GameTeamStatsDto gts : gameDto.getGameTeamStats()) {
            Team team = teamMap.get(gts.getTeamId());
            gameTeamStats.add(GameTeamStatsMapper.mapToGameTeamStats(gts, game, team));
        }
        game.setGameTeamStats(gameTeamStats);
        return game;
    }

    public static GameDto mapToGameDto(Game game) {
        GameDto gdto = new GameDto();
        gdto.setId(game.getId());
        gdto.setAwayTeam(game.getAwayTeam().getId());
        gdto.setHomeTeam(game.getHomeTeam().getId());
        gdto.setHomeScore(game.getHomeScore());
        gdto.setAwayScore(game.getAwayScore());
        gdto.setWinningTeam(game.getWinningTeam() != null ? game.getWinningTeam().getId() : null);

        List<GameTeamStatsDto> statsDto = new ArrayList<>();
        if (game.getGameTeamStats() != null) {
            for (GameTeamStats gts : game.getGameTeamStats()) {
                statsDto.add(GameTeamStatsMapper.mapToGameTeamStatsDto(gts));
            }
        }
        gdto.setGameTeamStats(statsDto);

        return gdto;
    }
}
