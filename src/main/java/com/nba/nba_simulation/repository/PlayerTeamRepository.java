package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, Long> {
    List<PlayerTeam> findByPlayerId(Long playerId);
}
