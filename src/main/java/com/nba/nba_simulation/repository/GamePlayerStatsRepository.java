package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.GamePlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GamePlayerStatsRepository extends JpaRepository<GamePlayerStats, Long> {
    List<GamePlayerStats> findByGameId(Long gameId);
    List<GamePlayerStats> findByPlayerId(Long playerId);
}
