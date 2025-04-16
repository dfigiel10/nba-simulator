package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, Long> {
}
