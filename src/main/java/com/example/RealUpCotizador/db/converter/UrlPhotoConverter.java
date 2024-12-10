package com.example.RealUpCotizador.db.converter;

import com.example.RealUpCotizador.db.dataInfluencer.UrlPhoto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;
import java.util.List;

@Converter
public class UrlPhotoConverter implements AttributeConverter<List<UrlPhoto>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<UrlPhoto> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting engagement rate to JSON", e);
        }
    }

    @Override
    public List<UrlPhoto> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<UrlPhoto>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON to engagement rate", e);
        }
    }
}
