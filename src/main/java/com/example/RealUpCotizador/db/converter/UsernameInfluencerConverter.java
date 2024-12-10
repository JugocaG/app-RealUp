package com.example.RealUpCotizador.db.converter;

import com.example.RealUpCotizador.db.dataInfluencer.UsernameInfluencer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Converter
public class UsernameInfluencerConverter implements AttributeConverter<List<UsernameInfluencer>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<UsernameInfluencer> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting URL list to JSON", e);
        }
    }

    @Override
    public List<UsernameInfluencer> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<UsernameInfluencer>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON to URL list", e);
        }
    }
}
