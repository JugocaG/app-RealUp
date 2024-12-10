package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.Influencer;
import com.example.RealUpCotizador.db.InfluencerRepositorySQL;
import com.example.RealUpCotizador.db.InfluencerRepository;
import com.example.RealUpCotizador.dto.InfluencerDTO;
import com.example.RealUpCotizador.dto.InfluencerMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final String pythonServiceUrl = "https://database-realup.onrender.com/generate-sql";

//    public List<Influencer> seeInfluencer() {
//        Pageable pageable = PageRequest.of(0, 45); // Página 0, 45 registros por página
//        Page<Influencer> page = influencerRepository.findAll(pageable);
//        return page.getContent(); // Extraer solo la lista de registros
//    }

    public List<Influencer> seeInfluencer() {
        return influencerRepository.findTop45ByInstagramFollowers();
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
        List<Map<String, Object>> results = influencerRepositorySQL.executeQuery(sqlQuery);

        // Transforma las claves de snake_case a camelCase y deserializa los valores JSON
        return results.stream()
                .map(this::transformAndDeserialize)
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

    private Map<String, Object> transformAndDeserialize(Map<String, Object> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> transformedResult = new HashMap<>();

        result.forEach((key, value) -> {
            String camelCaseKey = toCamelCase(key); // Convierte la clave a camelCase
            try {
                // Manejar deserialización específica para cada campo
                switch (camelCaseKey) {
                    case "urlPhoto":
                    case "usernameInfluencers":
                    case "urlSocialMedia":
                    case "followers":
                    case "priceInfluencer":
                    case "engagementRate":
                    case "audienceFemale":
                    case "audienceMale":
                        transformedResult.put(camelCaseKey, objectMapper.readValue(value.toString(), List.class));
                        break;
                    case "topAudienceCity":
                    case "topAudienceCountry":
                        transformedResult.put(camelCaseKey, objectMapper.readValue(value.toString(), Map.class));
                        break;
                    default:
                        transformedResult.put(camelCaseKey, value);
                }
            } catch (Exception e) {
                // Si hay un error, dejamos el valor original
                transformedResult.put(camelCaseKey, value);
            }
        });

        return transformedResult;
    }

    // Método para convertir claves de snake_case a camelCase
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
