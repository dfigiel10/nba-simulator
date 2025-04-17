package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.PlayerDto;
import com.nba.nba_simulation.dto.PlayerTeamDto;
import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.PlayerTeam;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.repository.PlayerRepository;
import com.nba.nba_simulation.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerTeamMapper {
    @Autowired
    private static PlayerRepository playerRepository;
    @Autowired
    private static TeamRepository teamRepository;
    public static PlayerTeam mapToPlayerTeam(PlayerTeamDto playerTeamDto) {

        PlayerTeam pt = new PlayerTeam();
        pt.setId(playerTeamDto.getId());
        Player player = playerRepository.findById(playerTeamDto.getPlayer())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Team team = teamRepository.findById(playerTeamDto.getTeam())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        pt.setTeam(team);
        pt.setPlayer(player);
        return pt;
    }

    public static PlayerTeamDto mapToPlayerTeamDto(PlayerTeam playerTeam) {

        PlayerTeamDto dto = new PlayerTeamDto();
        dto.setId(playerTeam.getId());
        dto.setPlayer(playerTeam.getPlayer().getId());
        dto.setTeam(playerTeam.getTeam().getId());
        return dto;
    }
}
