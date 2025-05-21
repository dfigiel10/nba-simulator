package com.nba.nba_simulation.dto;

import com.nba.nba_simulation.entity.GameTeamStats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    private Long id;
    private Long homeTeam; // changed from TeamDto to Long (teamId)
    private Long awayTeam; // changed from TeamDto to Long (teamId)
    private int homeScore;
    private int awayScore;
    private Long winningTeam; // changed from TeamDto to Long (teamId)
    private List<GameTeamStatsDto> gameTeamStats;
    private Long schedule;
}
