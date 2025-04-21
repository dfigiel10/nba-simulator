package com.nba.nba_simulation.dto;

import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameTeamStatsDto {

    private Long id;

    private Long gameId; // gameId

    private Long teamId; //

    private int points;
    private int rebounds;
    private int assists;
}
