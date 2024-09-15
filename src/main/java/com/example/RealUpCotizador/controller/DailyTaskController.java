package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.DailyTask;
import com.example.RealUpCotizador.dto.DailyTaskDTO;
import com.example.RealUpCotizador.service.DailyTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/manual-ops/daily")
public class DailyTaskController {

    DailyTaskService dailyTaskService;

    @GetMapping(path = "get-daily")
    public List<DailyTask> seeDaily(){
        return dailyTaskService.seeDailyTask();
    }

    @PostMapping(path = "add-daily")
    public String addDaily(@RequestBody DailyTaskDTO dailyTaskDTO){
        dailyTaskService.addDailyTask(dailyTaskDTO);
        return "Se ha añadido con exito";
    }

    @PutMapping(path = "update-daily")
    public String updateDaily(@RequestBody DailyTaskDTO dailyTaskDTO){
        dailyTaskService.updateDailyTask(dailyTaskDTO);
        return "Se ha actualizado con exito";
    }

    @PutMapping(path = "update-title-daily")
    public String updateDailyTitle(@RequestBody DailyTaskDTO dailyTaskDTO){
        dailyTaskService.updateDailyTaskTitle(dailyTaskDTO);
        return "Se ha actualizado con exito";
    }

    @PostMapping(path = "see-op-daily")
    public List<DailyTask> seeOpDaily(@RequestBody DailyTaskDTO dailyTaskDTO){
        return dailyTaskService.seeOpTask(dailyTaskDTO);
    }

    @PostMapping(path = "/delete-daily")
    public String deleteDaily(@RequestBody DailyTaskDTO dailyTaskDTO){
        dailyTaskService.deleteDailyTask(dailyTaskDTO);
        return "Se ha eliminado con exito";
    }

    @PostMapping(path = "/get-title")
    public List<DailyTask> getTitleTask(@RequestBody DailyTaskDTO dailyTaskDTO){
        return dailyTaskService.getTitleTask(dailyTaskDTO);
    }

    @PutMapping("/update-all")
    public ResponseEntity<String> updateDailyTasks(@RequestBody List<DailyTaskDTO> dailyTaskDTOs) {
        dailyTaskService.updateDailyTasks(dailyTaskDTOs);
        return ResponseEntity.ok("Tareas actualizadas con éxito");
    }

}
