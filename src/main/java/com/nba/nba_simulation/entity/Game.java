package com.nba.nba_simulation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="home_team_id")
    private Team homeTeam;

    @ManyToOne // many Games belong to one team
    @JoinColumn(name="away_team_id")
    private Team awayTeam;

    private int homeScore;
    private int awayScore;

    @ManyToOne
    @JoinColumn(name="winning_team_id")
    private Team winningTeam;

    @OneToMany(mappedBy="game", cascade = CascadeType.ALL) // One game has many game stats
    private List<GameTeamStats> gameTeamStats;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<GamePlayerStats> gamePlayerStats;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Long schedule;

}
