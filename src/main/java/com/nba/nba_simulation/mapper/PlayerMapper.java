package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.PlayerDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.PlayerTeam;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerMapper {
    // @Autowired
    // private static TeamRepository teamRepository;

    public static Player mapToPlayer(PlayerDto playerDto, List<Team> teams) {
        //List<Team> teams =
        Player player = new Player();
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(playerDto.getLastName());
        player.setId(playerDto.getId());
        player.setHeight(playerDto.getHeight());
        player.setWeight(playerDto.getWeight());

        List<PlayerTeam> playerTeams = new ArrayList<>();

        for (Team team : teams) {
            PlayerTeam playerTeam = new PlayerTeam();
            playerTeam.setPlayer(player);
            playerTeam.setTeam(team);
            playerTeams.add(playerTeam);
        }
        player.setTeams(playerTeams);
        return player;
    }

    public static PlayerDto mapToPlayerDto(Player player) {
        PlayerDto pdto = new PlayerDto();
        pdto.setId(player.getId());
        pdto.setFirstName(player.getFirstName());
        pdto.setLastName(player.getLastName());
        pdto.setHeight(player.getHeight());
        pdto.setWeight(player.getWeight());
        List<Long> teamIds = new ArrayList<>();
        for (PlayerTeam playerTeam : player.getTeams()) {
            teamIds.add(playerTeam.getTeam().getId());
        }
        pdto.setTeamIds(teamIds);
        return pdto;
    }
}
