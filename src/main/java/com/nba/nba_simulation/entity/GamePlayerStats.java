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
@Table(name="gamePlayerStats")
public class GamePlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // many gamePlayerStats have one game
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne // many gamePlayerStats have one player
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private int points;
    private int rebounds;
    private int assists;
}
