package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.WeeklyWorkload;
import com.example.RealUpCotizador.dto.WeeklyWorkloadDTO;
import com.example.RealUpCotizador.service.WeeklyWorkloadService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Data
@RestController
@RequestMapping(path = "/manual-ops/weekly")
public class WeeklyWorkloadController {

    WeeklyWorkloadService weeklyWorkloadService;

    @GetMapping(path = "get-weekly-load")
    public WeeklyWorkload getWeeklyWorkload(){
        return weeklyWorkloadService.getWeeklyLoad();
    }

    @PostMapping(path = "add-weekly-load")
    public String addWeeklyWorkload(){
        weeklyWorkloadService.addWeeklyLoad();
        return "Data successfully obtained";
    }

    @PutMapping(path = "update-weekly-load")
    public String updateWeeklyWorkload(@RequestBody WeeklyWorkloadDTO weeklyWorkloadDTO){
        weeklyWorkloadService.updateWeeklyLoad(weeklyWorkloadDTO);
        return "Data successfully updated";
    }
}