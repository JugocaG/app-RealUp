package com.example.RealUpCotizador.db.dataInfluencer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopAudienceLocation {
    private String name;
    private Double weight;
    private String country;
}
