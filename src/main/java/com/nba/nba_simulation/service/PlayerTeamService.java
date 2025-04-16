package com.nba.nba_simulation.service;

import com.nba.nba_simulation.dto.PlayerTeamDto;

public interface PlayerTeamService {
    PlayerTeamDto assignPlayerToTeam(Long playerId, Long teamId);
}
