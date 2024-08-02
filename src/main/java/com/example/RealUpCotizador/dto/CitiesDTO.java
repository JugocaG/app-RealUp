package com.example.RealUpCotizador.dto;

import lombok.Data;

@Data
public class CitiesDTO {

    private Long id;

    private String city_ascii;

    private String country;

    private String iso3;

    private Double population;
}
