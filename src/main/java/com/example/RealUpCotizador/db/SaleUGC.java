package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.vo.CampaignObjective;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sale_ugc")
public class SaleUGC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_ugc_sequence")
    @SequenceGenerator(name = "sale_ugc_sequence", sequenceName = "sale_ugc_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String name_client;

    private String campaign_name;

    private String type_product;

    private String name_product;

    private String brief;

    @ElementCollection
    private List<String> country;

    @ElementCollection
    private List<String> cities;

    private Boolean guideline;

    private Integer number_short_videos;

    private Integer number_long_videos;

    private Integer number_carrousel;

    private Integer number_creators;

    @ElementCollection
    private List<CampaignObjective> campaign_objective;

    private String delivery;

    private Double price;
}
