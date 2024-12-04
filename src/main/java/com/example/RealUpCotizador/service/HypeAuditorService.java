package com.example.RealUpCotizador.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

import java.util.Map;

@Service
@AllArgsConstructor
@Data
public class HypeAuditorService {

    private final RestTemplate restTemplate;
    private final String url = "https://hypeauditor.com/api/method/auditor.searchSandbox";
    private final String authId = "360838"; // Reemplaza con tu Auth ID
    private final String authToken = "$2y$04$Ai3PO.ApJUZd2tSpIEvrwuJowWPOVY5DwCE4RNnTVTD6ayQHKtZh6"; // Reemplaza con tu Auth Token
    public String getInstagramReport(String username, String authId, String authToken) {
        String url = "https://hypeauditor.com/api/method/auditor.report?username=" + username + "&v=2";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-auth-id", authId);
        headers.set("x-auth-token", authToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String sendRequestToHypeAuditor(Map<String, Object> requestBody) {
        // Configurar los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Id", authId);
        headers.set("X-Auth-Token", authToken);
        headers.set("Content-Type", "application/json");

        // Crear la entidad HttpEntity con headers y body
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Realizar la solicitud usando RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );

        // Devolver la respuesta como String
        return response.getBody();
    }
}
