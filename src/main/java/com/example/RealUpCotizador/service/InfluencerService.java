package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.Influencer;
import com.example.RealUpCotizador.db.InfluencerRepositorySQL;
import com.example.RealUpCotizador.db.InfluencerRepository;
import com.example.RealUpCotizador.dto.InfluencerDTO;
import com.example.RealUpCotizador.dto.InfluencerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InfluencerService {

    private InfluencerRepositorySQL influencerRepositorySQL;

    InfluencerRepository influencerRepository;

    private final InfluencerMapper influencerMapper;

    private final String pythonServiceUrl = "http://localhost:5001/generate-sql";

    public List<Influencer> seeInfluencer(){
        return influencerRepository.findAll();
    }

    public String getSQLFromPrompt(String prompt) {
        // Llama al microservicio Python
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> request = Map.of("prompt", prompt);

        Map<String, Object> response = restTemplate.postForObject(pythonServiceUrl, request, Map.class);
        if (response == null || !response.containsKey("sql_query")) {
            throw new RuntimeException("Failed to generate SQL from prompt");
        }

        return response.get("sql_query").toString();
    }

    public List<Map<String, Object>> executeQuery(String sqlQuery) {
        // Ejecuta la consulta SQL y obtiene los resultados
        List<Map<String, Object>> results = influencerRepositorySQL.executeQuery(sqlQuery);

        // Transforma las claves de snake_case a camelCase
        return results.stream()
                .map(this::convertKeysToCamelCase)
                .collect(Collectors.toList());
    }

    // Convierte las claves de un mapa de snake_case a camelCase
    private Map<String, Object> convertKeysToCamelCase(Map<String, Object> map) {
        Map<String, Object> camelCaseMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String camelCaseKey = toCamelCase(entry.getKey());
            camelCaseMap.put(camelCaseKey, entry.getValue());
        }
        return camelCaseMap;
    }

    // Método para convertir una clave de snake_case a camelCase
    private String toCamelCase(String snakeCase) {
        StringBuilder camelCase = new StringBuilder();
        boolean nextCharUpperCase = false;
        for (char c : snakeCase.toCharArray()) {
            if (c == '_') {
                nextCharUpperCase = true;
            } else if (nextCharUpperCase) {
                camelCase.append(Character.toUpperCase(c));
                nextCharUpperCase = false;
            } else {
                camelCase.append(c);
            }
        }
        return camelCase.toString();
    }

    public Influencer saveInfluencer(InfluencerDTO influencerDTO) {
        // Convierte el DTO a la Entidad automáticamente
        Influencer influencer = influencerMapper.toEntity(influencerDTO);

        // Aquí puedes guardar el influencer en tu repositorio
        influencerRepository.save(influencer);
        return influencer;
    }

}
