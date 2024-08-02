package com.example.RealUpCotizador.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_sequence")
    @SequenceGenerator(name = "campaign_sequence", sequenceName = "campaign_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

}
