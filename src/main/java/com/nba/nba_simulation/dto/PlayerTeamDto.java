package com.nba.nba_simulation.dto;

import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTeamDto {

    private Long id;

    private PlayerDto player;

    private TeamDto team;
}
