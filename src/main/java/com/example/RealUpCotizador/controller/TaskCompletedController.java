package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.TaskCompleted;
import com.example.RealUpCotizador.dto.TaskCompletedDTO;
import com.example.RealUpCotizador.service.TaskCompletedService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Data
@RestController
@RequestMapping(path = "/manual-ops/checklist")
public class TaskCompletedController {

    TaskCompletedService taskCompletedService;


    @GetMapping(path = "get-task-id/{idCampaign}")
    public TaskCompleted seeTaskCompletedID(@PathVariable("idCampaign") Long idCampaign){
        return taskCompletedService.getTaskCompleted(idCampaign);
    }

    @PutMapping("update-task-id/{idCampaign}")
    public ResponseEntity<?> updateChecklist(@PathVariable Long idCampaign, @RequestBody TaskCompletedDTO taskCompletedDTO) {
        try {
            taskCompletedService.updateChecklist(idCampaign, taskCompletedDTO);
            return ResponseEntity.ok().body("Checklist updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating checklist: " + e.getMessage());
        }
    }

}
