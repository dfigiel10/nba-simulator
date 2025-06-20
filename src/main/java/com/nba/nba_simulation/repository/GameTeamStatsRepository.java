package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.dto.GameTeamStatsDto;
import com.nba.nba_simulation.entity.GameTeamStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameTeamStatsRepository extends JpaRepository<GameTeamStats, Long> {

    @Query(value = "select points, rebounds, assists from game_team_stats \n" +
            "where game_id = :gameId and team_id = :teamId", nativeQuery = true)
    GameTeamStatsDto getBoxscore(@Param("gameId") Long gameId, @Param("teamId") Long teamId);
}
