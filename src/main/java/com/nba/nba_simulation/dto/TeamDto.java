package com.nba.nba_simulation.dto;

import java.util.*;

import com.nba.nba_simulation.entity.PlayerTeam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private Long id;
    private String name;
    private List<PlayerTeamDto> players = new ArrayList<>();
}
