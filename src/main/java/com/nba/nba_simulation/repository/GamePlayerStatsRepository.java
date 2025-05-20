package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.dto.LeadingAssistsDto;
import com.nba.nba_simulation.dto.LeadingReboundsDto;
import com.nba.nba_simulation.dto.LeadingScorerDto;
import com.nba.nba_simulation.entity.GamePlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GamePlayerStatsRepository extends JpaRepository<GamePlayerStats, Long> {
    List<GamePlayerStats> findByGameId(Long gameId);
    List<GamePlayerStats> findByPlayerId(Long playerId);

    @Query(value = "select round(avg(gps.points), 2) avgStat, player.first_name firstName, player.last_name lastName, team.name teamName\n" +
            "\tfrom game_player_stats gps\n" +
            "\tjoin player\n" +
            "\t\ton player.id = gps.player_id\n" +
            "\tjoin team\n" +
            "\t\ton team.id = gps.team_id\n" +
            "\tgroup by player.first_name, player.last_name, team.name\n" +
            "\torder by avg(points) desc\n" +
            "\tlimit 5", nativeQuery = true)
    List<LeadingScorerDto> leadingPointsPerGame();

    @Query(value = "select round(avg(gps.assists), 2) avgStat, player.first_name firstName, player.last_name lastName, team.name teamName\n" +
            "\tfrom game_player_stats gps\n" +
            "\tjoin player\n" +
            "\t\ton player.id = gps.player_id\n" +
            "\tjoin team\n" +
            "\t\ton team.id = gps.team_id\n" +
            "\tgroup by player.first_name, player.last_name, team.name\n" +
            "\torder by avg(assists) desc\n" +
            "\tlimit 5", nativeQuery = true)
    List<LeadingAssistsDto> leadingAssistsPerGame();

    @Query(value = "select round(avg(gps.rebounds), 2) avgStat, player.first_name firstName, player.last_name lastName, team.name teamName\n" +
            "\tfrom game_player_stats gps\n" +
            "\tjoin player\n" +
            "\t\ton player.id = gps.player_id\n" +
            "\tjoin team\n" +
            "\t\ton team.id = gps.team_id\n" +
            "\tgroup by player.first_name, player.last_name, team.name\n" +
            "\torder by avg(rebounds) desc\n" +
            "\tlimit 5", nativeQuery = true)
    List<LeadingReboundsDto> leadingReboundsPerGame();
}
