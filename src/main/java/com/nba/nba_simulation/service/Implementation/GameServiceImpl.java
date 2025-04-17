package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.mapper.GameMapper;
import com.nba.nba_simulation.repository.GameRepository;
import com.nba.nba_simulation.repository.TeamRepository;
import com.nba.nba_simulation.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public GameDto createGame(GameDto gameDto) { // only create the game, don't play it
        Team homeTeam = teamRepository.findById(gameDto.getHomeTeam())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        Team awayTeam = teamRepository.findById(gameDto.getAwayTeam())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        Team winningTeam = null;

        Set<Long> gameTeamStatIds = new HashSet<>();
        for (GameTeamStatsDto dto : gameDto.getGameTeamStats()) {
            gameTeamStatIds.add(dto.getTeamId());
        }
        List<Team> teamIds = teamRepository.findAllById(gameTeamStatIds);

        Map<Long, Team> teamMap = new HashMap<>();
        for (Team team : teamIds) {
            teamMap.put(team.getId(), team);
        }

        Game game = GameMapper.mapToGame(gameDto, homeTeam, awayTeam, winningTeam, teamMap);
        Game savedGame = gameRepository.save(game);
//        Game game = new Game();
//        game.setHomeTeam(homeTeam);
//        game.setAwayTeam(awayTeam);
//        game.setHomeScore(0);
//        game.setAwayScore(0);
//        game.setWinningTeam(null);
//        game.setGameTeamStats(new ArrayList<>());
//        Game savedGame = gameRepository.save(game);
        return GameMapper.mapToGameDto(savedGame);
    }
}
