package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.service.ModashService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ModashController {

    private ModashService modashService;

    @GetMapping("manual-ops/api/modash/ig-report")
    public String getReport(@RequestParam String username) {
        return modashService.getInstagramReport(username);
    }


    @PostMapping("manual-ops/api/modash/ig-discover")
    public ResponseEntity<String> discoverInfluencers(@RequestBody Map<String, Object> requestBody) {
        // Llamar al servicio para enviar la solicitud a HypeAuditor
        String response = modashService.sendRequestToModash(requestBody);
        // Devolver la respuesta al cliente
        return ResponseEntity.ok(response);
    }
}
