package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.Campaign;
import com.example.RealUpCotizador.dto.CampaignDTO;
import com.example.RealUpCotizador.dto.TaskCompletedDTO;
import com.example.RealUpCotizador.service.CampaignService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
@RequestMapping(path = "/manual-ops")
public class CampaignController {

    CampaignService campaignService;

    @GetMapping(path = "see-campaign")
    public List<Campaign> seeCampaign(){
        return campaignService.seeCampaign();
    }

    @PostMapping(path = "add-campaign")
    public String addCampaign(@RequestBody CampaignDTO campaignDTO){
        campaignService.addCampaign(campaignDTO);
        return "Campaign added without error";
    }

    @GetMapping("preparation")
    public List<Campaign> getCampaignsInPreparation() {
        return campaignService.getCampaignsInPreparation();
    }

    @GetMapping("execution")
    public List<Campaign> getCampaignsInExecution() {
        return campaignService.getCampaignsInExecution();
    }

    @GetMapping("closed")
    public List<Campaign> getCampaignsClosed() {
        return campaignService.getCampaignsClosed();
    }

    @PutMapping("update-task-completed/{idCampaign}")
    public ResponseEntity<?> updateChecklist(@PathVariable Long idCampaign, @RequestBody CampaignDTO campaignDTO) {
        try {
            campaignService.updateTaskNumber(campaignDTO, idCampaign);
            return ResponseEntity.ok().body("Checklist updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating checklist: " + e.getMessage());
        }
    }

}
