package com.nba.nba_simulation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="schedule")
public class Schedule {
    private Long id;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Game> games = new ArrayList<>();
}
