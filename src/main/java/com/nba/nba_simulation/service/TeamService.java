package com.nba.nba_simulation.service;



import com.nba.nba_simulation.dto.TeamDto;
import com.nba.nba_simulation.entity.Player;

import java.util.*;

public interface TeamService {

    TeamDto createTeam(TeamDto teamDto);
    TeamDto getTeam(Long teamId);
//    void addPlayer(Long teamId, Long playerId);
//    Set<Player> getRoster(Long teamId);
//    void draftPlayer(Long teamId, Long playerId);
}
