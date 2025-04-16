package com.nba.nba_simulation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTeamRequest {
    Long playerId;
    Long teamId;
}
