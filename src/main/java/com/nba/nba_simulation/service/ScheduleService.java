package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.ScheduleDto;

public interface ScheduleService {
    ScheduleDto createSchedule();
    ScheduleDto getSchedule(Long scheduleId);
}
