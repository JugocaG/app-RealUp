package com.example.RealUpCotizador.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_crowdposting_sequence")
    @SequenceGenerator(name = "sale_crowdposting_sequence", sequenceName = "sale_crowdposting_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String city_ascii;

    private String country;

    private String iso3;

    private Double population;
}
