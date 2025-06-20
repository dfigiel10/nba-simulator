package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.GameTeamStats;
import com.nba.nba_simulation.mapper.GameTeamStatsMapper;
import com.nba.nba_simulation.repository.GameTeamStatsRepository;
import com.nba.nba_simulation.service.GameTeamStatsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameTeamStatsImpl implements GameTeamStatsService {
    @Autowired
    private GameTeamStatsRepository gameTeamStatsRepository;

    public GameTeamStatsDto getBoxscore(Long gameId, Long teamId) {
         return gameTeamStatsRepository.getBoxscore(gameId, teamId);
//        return GameTeamStatsMapper.mapToGameTeamStatsDto(gts);
    }
}
