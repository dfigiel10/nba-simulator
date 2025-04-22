package com.nba.nba_simulation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GamePlayerStatsDto {
    private Long id;
    private Long gameId;
    private Long playerId;
    private int points;
    private int rebounds;
    private int assists;
}
