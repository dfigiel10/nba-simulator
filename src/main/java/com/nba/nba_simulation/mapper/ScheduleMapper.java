package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.ScheduleDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMapper {
    public static ScheduleDto mapToScheduleDto(Schedule schedule) {
        ScheduleDto sdto = new ScheduleDto();
        List<Long> gameIDs = new ArrayList<>();
        for (Game game : schedule.getGames()) {
            gameIDs.add(game.getId());
        }
        sdto.setId(schedule.getId());
        sdto.setGamesIDs(gameIDs);
        return sdto;
    }

}
