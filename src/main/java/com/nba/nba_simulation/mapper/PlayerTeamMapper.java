package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.PlayerDto;
import com.nba.nba_simulation.dto.PlayerTeamDto;
import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.PlayerTeam;
import com.nba.nba_simulation.entity.Team;

public class PlayerTeamMapper {
    public static PlayerTeam mapToPlayerTeam(PlayerTeamDto playerTeamDto) {

        Player player = new Player();
        player.setId(playerTeamDto.getPlayer().getId());
        player.setFirstName(playerTeamDto.getPlayer().getFirstName());
        player.setLastName(playerTeamDto.getPlayer().getLastName());
        player.setHeight(playerTeamDto.getPlayer().getHeight());
        player.setWeight(playerTeamDto.getPlayer().getWeight());

        Team team = new Team();
        team.setId(playerTeamDto.getTeam().getId());
        team.setName(playerTeamDto.getTeam().getName());
        // team.setPlayers(playerTeamDto.getTeam().getPlayers());

        PlayerTeam playerTeam = new PlayerTeam();
        // playerTeam.setId(playerTeam.getId());
        playerTeam.setPlayer(player);
        playerTeam.setTeam(team);

        return playerTeam;
    }

    public static PlayerTeamDto mapToPlayerTeamDto(PlayerTeam playerTeam) {

        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(playerTeam.getPlayer().getId());
        playerDto.setFirstName(playerTeam.getPlayer().getFirstName());
        playerDto.setLastName(playerTeam.getPlayer().getLastName());
        playerDto.setHeight(playerTeam.getPlayer().getHeight());
        playerDto.setWeight(playerTeam.getPlayer().getWeight());

        TeamDto teamDto = new TeamDto();
        teamDto.setId(playerTeam.getTeam().getId());
        // teamDto.setPlayers(playerTeam.getTeam().getPlayers());
        teamDto.setName(playerTeam.getTeam().getName());

        PlayerTeamDto dto = new PlayerTeamDto();
        dto.setId(playerTeam.getId());
        dto.setPlayer(playerDto);
        dto.setTeam(teamDto);
        return dto;
    }
}
