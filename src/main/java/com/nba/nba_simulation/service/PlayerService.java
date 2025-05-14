package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    PlayerDto createPlayer(PlayerDto playerDto);
    PlayerDto getPlayer(Long playerId);
    List<PlayerDto> getAllPlayers();
}
