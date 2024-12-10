package com.example.RealUpCotizador.db.converter;

import com.example.RealUpCotizador.db.dataInfluencer.TopAudienceLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Converter
public class TopAudienceLocationConverter implements AttributeConverter<Map<String, List<TopAudienceLocation>>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, List<TopAudienceLocation>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting top audience city to JSON", e);
        }
    }

    @Override
    public Map<String, List<TopAudienceLocation>> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, List<TopAudienceLocation>>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON to top audience city", e);
        }
    }
}