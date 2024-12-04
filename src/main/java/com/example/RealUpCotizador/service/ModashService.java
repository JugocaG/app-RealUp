package com.example.RealUpCotizador.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@AllArgsConstructor
@Data
@Service
public class ModashService {
    private final RestTemplate restTemplate;
    private final String urlModash = "https://api.modash.io";
    private final String authToken = "528dzwPwbCQr8ggu1VjiqH2RwIwouGpZ"; // Reemplaza con tu Auth Token

    public String getInstagramReport(String username) {
        String url = urlModash + "/v1/instagram/profile/" + username + "/report";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken); // Prefijo "Bearer" añadido

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }


    public String sendRequestToModash(Map<String, Object> requestBody) {
        // Configurar los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken); // Prefijo "Bearer" añadido

        // Crear la entidad HttpEntity con headers y body
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Realizar la solicitud usando RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                urlModash + "/v1/instagram/search",
                HttpMethod.POST,
                entity,
                String.class
        );

        // Devolver la respuesta como String
        return response.getBody();
    }

}
