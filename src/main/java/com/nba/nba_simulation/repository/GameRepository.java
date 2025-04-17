package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
