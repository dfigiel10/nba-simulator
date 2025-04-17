package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.PlayerTeamDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.PlayerTeam;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.mapper.PlayerMapper;
import com.nba.nba_simulation.mapper.PlayerTeamMapper;
import com.nba.nba_simulation.repository.PlayerRepository;
import com.nba.nba_simulation.repository.PlayerTeamRepository;
import com.nba.nba_simulation.repository.TeamRepository;
import com.nba.nba_simulation.service.PlayerTeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerTeamServiceImpl implements PlayerTeamService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerTeamRepository playerTeamRepository;

    public PlayerTeamDto assignPlayerToTeam(Long playerId, Long teamId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player Not Found"));
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team Not Found"));

        PlayerTeam playerTeam = new PlayerTeam();
        playerTeam.setPlayer(player);
        playerTeam.setTeam(team);

        player.getTeams().add(playerTeam);
        team.getPlayers().add(playerTeam);

        PlayerTeam savedPlayerTeam = playerTeamRepository.save(playerTeam);
        return PlayerTeamMapper.mapToPlayerTeamDto(savedPlayerTeam);
    }
}
