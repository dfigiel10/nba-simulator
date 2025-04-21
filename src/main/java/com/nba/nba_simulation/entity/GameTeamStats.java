package com.nba.nba_simulation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="gameTeamStats")
public class GameTeamStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // many gameTeamStats have one game
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne // many gameTeamStats have one team
    @JoinColumn(name="team_id")
    private Team team;

    private int points;
    private int rebounds;
    private int assists;
}
