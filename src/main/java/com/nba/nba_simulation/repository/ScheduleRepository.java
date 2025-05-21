package com.nba.nba_simulation.repository;

import com.nba.nba_simulation.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
