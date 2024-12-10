package com.example.RealUpCotizador.db.dataInfluencer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngagementRate {
    private String media;
    private Double value;
}
