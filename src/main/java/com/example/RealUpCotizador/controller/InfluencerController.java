package com.example.RealUpCotizador.controller;
import com.example.RealUpCotizador.db.Campaign;
import com.example.RealUpCotizador.db.Influencer;
import com.example.RealUpCotizador.dto.CampaignDTO;
import com.example.RealUpCotizador.dto.InfluencerDTO;
import com.example.RealUpCotizador.service.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manual-ops/api/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @GetMapping(path = "/see-influencer")
    public List<Influencer> seeInfluencer(){
        return influencerService.seeInfluencer();
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchInfluencers(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt"); // Prompt recibido del frontend
        if (prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Prompt is required");
        }

        try {
            // Llama al microservicio de Python para obtener la consulta SQL
            String sqlQuery = influencerService.getSQLFromPrompt(prompt);

            // Ejecuta la consulta SQL contra la base de datos
            List<Map<String, Object>> results = influencerService.executeQuery(sqlQuery);
            return ResponseEntity.ok(results);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PostMapping(path = "add-influencer")
    public String addCampaign(@RequestBody InfluencerDTO influencerDTO){
        influencerService.saveInfluencer(influencerDTO);
        return "Campaign added without error";
    }

    @GetMapping("proxy-image")
    public ResponseEntity<byte[]> getImage(@RequestParam String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            byte[] imageBytes = restTemplate.getForObject(url, byte[].class);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpeg");

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
