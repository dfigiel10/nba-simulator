package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.GamePlayerStatsDto;
import com.nba.nba_simulation.entity.GamePlayerStats;
import com.nba.nba_simulation.mapper.GamePlayerStatsMapper;
import com.nba.nba_simulation.repository.GamePlayerStatsRepository;
import com.nba.nba_simulation.service.GamePlayerStatsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GamePlayerStatsImpl implements GamePlayerStatsService{
    @Autowired
    private GamePlayerStatsRepository gamePlayerStatsRepository;

    @Override
    public List<GamePlayerStatsDto> getBoxScore(Long gameId) {
        List<GamePlayerStats> boxScore = gamePlayerStatsRepository.findByGameId(gameId);
        List<GamePlayerStatsDto> boxScoreDto = new ArrayList<>();
        for (GamePlayerStats gps : boxScore) {
            boxScoreDto.add(GamePlayerStatsMapper.mapToGameTeamStatsDto(gps));
        }
        return boxScoreDto;
    }

    @Override
    public List<GamePlayerStatsDto> getPlayerStats(Long playerId) {
        List<GamePlayerStats> playerStats = gamePlayerStatsRepository.findByPlayerId(playerId);
        List<GamePlayerStatsDto> playerStatsDto = new ArrayList<>();
        for (GamePlayerStats ps : playerStats) {
            playerStatsDto.add(GamePlayerStatsMapper.mapToGameTeamStatsDto(ps));
        }
        return playerStatsDto;
    }
}
