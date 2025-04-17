package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.PlayerTeamDto;

import java.util.List;

public interface PlayerTeamService {
    PlayerTeamDto assignPlayerToTeam(Long playerId, Long teamId);
    List<PlayerTeamDto> getPlayerTeamHistory(Long playerId);
}
