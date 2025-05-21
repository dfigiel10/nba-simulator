package com.nba.nba_simulation.dto;

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
public class ScheduleDto {
    private Long id;
    private List<Long> gamesIDs = new ArrayList<>();
}
