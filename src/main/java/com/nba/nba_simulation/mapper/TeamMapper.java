package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.repository.PlayerRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamMapper {
    public static TeamDto mapToTeamDto(Team team) {
        TeamDto tdto = new TeamDto();
        tdto.setId(team.getId());
        tdto.setName(team.getName());
        return tdto;

    }

    public static Team mapToTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        return team;
    }
}
