package com.nba.nba_simulation.controller;

import com.nba.nba_simulation.dto.ScheduleDto;
import com.nba.nba_simulation.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/createSchedule")
    public ResponseEntity<ScheduleDto> createSchedule() {
        ScheduleDto sdto = scheduleService.createSchedule();
        return new ResponseEntity<>(sdto, HttpStatus.CREATED);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable Long scheduleId) {
        ScheduleDto schedule = scheduleService.getSchedule(scheduleId);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
