package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.vo.CampaignObjective;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sale_crowdposting")
public class SaleCrowdposting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_crowdposting_sequence")
    @SequenceGenerator(name = "sale_crowdposting_sequence", sequenceName = "sale_crowdposting_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String name_client;

    private Integer reach;

    private String country;

    @ElementCollection
    private List<String> cities;

    private Integer number_cities;

    private CampaignObjective campaign_objective;

    private Long price;


}
