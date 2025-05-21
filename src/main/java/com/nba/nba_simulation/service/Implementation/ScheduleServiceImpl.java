package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.GameDto;
import com.nba.nba_simulation.dto.ScheduleDto;
import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Schedule;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.mapper.ScheduleMapper;
import com.nba.nba_simulation.repository.ScheduleRepository;
import com.nba.nba_simulation.service.GameService;
import com.nba.nba_simulation.service.ScheduleService;
import com.nba.nba_simulation.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private TeamService teamService;

    @Autowired
    private GameService gameService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleDto createSchedule() {
        List<TeamDto> teams = teamService.getAllTeams();
        Schedule schedule = new Schedule();
        List<Game> games = new ArrayList<>();

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                TeamDto homeTeam = teams.get(i);
                TeamDto awayTeam = teams.get(j);
                GameDto gdto = new GameDto();
                gdto.setHomeTeam(homeTeam.getId());
                gdto.setAwayTeam(awayTeam.getId());
                gdto.setHomeScore(0);
                gdto.setAwayScore(0);
                gdto.setWinningTeam(null);
                gdto.setGameTeamStats(new ArrayList<>());
                gdto.setSchedule(schedule.getId());
                Game game = gameService.createGame(gdto, schedule);
                games.add(game);
            }
        }
        schedule.setGames(games);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleMapper.mapToScheduleDto(savedSchedule);
    }

    @Override
    public ScheduleDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).
                orElseThrow(() -> new RuntimeException("Schedule not found"));
        return ScheduleMapper.mapToScheduleDto(schedule);
    }
}
