package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findPlayersByTeams_Team_Id(Long teamId);
}
