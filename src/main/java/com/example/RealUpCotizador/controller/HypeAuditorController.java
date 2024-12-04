package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.service.HypeAuditorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class HypeAuditorController {
    private final HypeAuditorService hypeAuditorService;


    private final String authId = "360838";
    private final String authToken = "$2y$04$Ai3PO.ApJUZd2tSpIEvrwuJowWPOVY5DwCE4RNnTVTD6ayQHKtZh6";


    @GetMapping("manual-ops/api/report")
    public String getReport(@RequestParam String username) {
        return hypeAuditorService.getInstagramReport(username, authId, authToken);
    }

    @PostMapping("manual-ops/api/discover")
    public ResponseEntity<String> sendRequest(@RequestBody Map<String, Object> requestBody) {
        // Llamar al servicio para enviar la solicitud a HypeAuditor
        String response = hypeAuditorService.sendRequestToHypeAuditor(requestBody);

        // Devolver la respuesta al cliente
        return ResponseEntity.ok(response);
    }



}
