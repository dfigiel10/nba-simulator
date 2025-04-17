package com.nba.nba_simulation.service.Implementation;

import com.nba.nba_simulation.dto.PlayerDto;
import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.Team;
import com.nba.nba_simulation.mapper.PlayerMapper;
import com.nba.nba_simulation.repository.PlayerRepository;
import com.nba.nba_simulation.repository.TeamRepository;
import com.nba.nba_simulation.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public PlayerDto createPlayer(PlayerDto playerDto) {
        List<Team> teams = teamRepository.findAllById(playerDto.getTeamIds());
        Player player = PlayerMapper.mapToPlayer(playerDto, teams);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.mapToPlayerDto(savedPlayer);
    }
}
