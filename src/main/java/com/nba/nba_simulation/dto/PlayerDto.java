package com.nba.nba_simulation.dto;

import com.nba.nba_simulation.entity.Player;
import com.nba.nba_simulation.entity.PlayerTeam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private List<Long> teamIds = new ArrayList<>();
}
