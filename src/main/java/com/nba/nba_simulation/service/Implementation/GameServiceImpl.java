package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.*;
import com.nba.nba_simulation.mapper.GameMapper;
import com.nba.nba_simulation.repository.GameRepository;
import com.nba.nba_simulation.repository.PlayerRepository;
import com.nba.nba_simulation.repository.TeamRepository;
import com.nba.nba_simulation.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.*;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

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

    public GameDto playGame(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        Team homeTeam = game.getHomeTeam();
        Team awayTeam = game.getAwayTeam();

        List<GamePlayerStats> allStats = new ArrayList<>();
        List< Player> homePlayers = playerRepository.findPlayersByTeams_Team_Id(homeTeam.getId());
        List<Player> awayPlayers = playerRepository.findPlayersByTeams_Team_Id(awayTeam.getId());
        for (Player p : homePlayers) {
            allStats.add(simulatePlayerStats(p, game, homeTeam));
        }

        for (Player p : awayPlayers) {
            allStats.add(simulatePlayerStats(p, game, awayTeam));
        }

        Map<Long, GameTeamStats> teamStats = aggregateTeamStats(allStats, game); // returns a map of each team id and their team stats
        GameTeamStats homeTeamStats = teamStats.get(homeTeam.getId());
        GameTeamStats awayTeamStats = teamStats.get(awayTeam.getId());

        game.setHomeScore(homeTeamStats.getPoints());
        game.setAwayScore(awayTeamStats.getPoints());
        if (homeTeamStats.getPoints() >= awayTeamStats.getPoints()) {
            game.setWinningTeam(homeTeam);
        } else {
            game.setWinningTeam(awayTeam);
        }
        List<GameTeamStats> homeAndAwayStats = new ArrayList<>();
        homeAndAwayStats.add(homeTeamStats);
        homeAndAwayStats.add(awayTeamStats);
        // game.setGameTeamStats(List.of(homeTeamStats, awayTeamStats));
        game.setGameTeamStats(homeAndAwayStats);
        game.setGamePlayerStats(allStats);
        Game savedGame = gameRepository.save(game);
        return GameMapper.mapToGameDto(savedGame);

    }

    public static GamePlayerStats simulatePlayerStats(Player player, Game game, Team team) {
        Random random = new Random();
        GamePlayerStats gps = new GamePlayerStats();
        gps.setGame(game);
        gps.setPlayer(player);
        gps.setTeam(team);
        gps.setPoints(random.nextInt(40));
        gps.setRebounds(random.nextInt(20));
        gps.setAssists(random.nextInt(15));
        return gps;
    }

    public static Map<Long, GameTeamStats> aggregateTeamStats(List<GamePlayerStats> allStats, Game game) {
        Map<Long, GameTeamStats> teamStatsMap = new HashMap<>();
        for (GamePlayerStats stat : allStats) {
            Long teamId = stat.getTeam().getId();
            GameTeamStats teamStats = teamStatsMap.getOrDefault(teamId, new GameTeamStats());
            teamStats.setGame(stat.getGame());
            teamStats.setTeam(stat.getTeam());
            teamStats.setPoints(teamStats.getPoints() + stat.getPoints());
            teamStats.setRebounds(teamStats.getRebounds() + stat.getRebounds());
            teamStats.setAssists(teamStats.getAssists() + stat.getAssists());
            teamStatsMap.put(teamId, teamStats);
        }

        return teamStatsMap;
    }
}
