package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.mapper.TeamMapper;
import com.nba.nba_simulation.repository.TeamRepository;
import com.nba.nba_simulation.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = TeamMapper.mapToTeam(teamDto);
        Team savedTeam = teamRepository.save(team);
        return TeamMapper.mapToTeamDto(savedTeam);
    }

    @Override
    public TeamDto getTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        return TeamMapper.mapToTeamDto(team);
    }
}
