package com.nba.nba_simulation.mapper;

import com.nba.nba_simulation.dto.PlayerDto;
import com.nba.nba_simulation.entity.Player;

import java.util.stream.Collectors;

public class PlayerMapper {
    public static Player mapToPlayer(PlayerDto playerDto) {
        //List<Team> teams =
        Player player = new Player();
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(playerDto.getLastName());
        player.setId(playerDto.getId());
        player.setHeight(playerDto.getHeight());
        player.setWeight(playerDto.getWeight());
        return player;
    }

    public static PlayerDto mapToPlayerDto(Player player) {
        PlayerDto pdto = new PlayerDto();
        pdto.setId(player.getId());
        pdto.setFirstName(player.getFirstName());
        pdto.setLastName(player.getLastName());
        pdto.setHeight(player.getHeight());
        pdto.setWeight(player.getWeight());
        // pdto.setTeams(player.getTeams());
        return pdto;
    }
}
