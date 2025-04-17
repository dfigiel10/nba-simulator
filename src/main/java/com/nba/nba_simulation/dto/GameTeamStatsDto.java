package com.nba.nba_simulation.dto;

import com.nba.nba_simulation.entity.Game;
import com.nba.nba_simulation.entity.Team;
import jakarta.persistence.*;

public class GameTeamStatsDto {

    private Long id;

    private GameDto game;

    private TeamDto team;

    private int points;
    private int rebounds;
    private int assists;
}
