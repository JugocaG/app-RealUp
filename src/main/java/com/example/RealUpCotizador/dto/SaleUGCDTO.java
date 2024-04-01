package com.example.RealUpCotizador.dto;


import com.example.RealUpCotizador.vo.CampaignObjective;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SaleUGCDTO {

    private String name_client;

    private String campaign_name;

    private String type_product;

    private String name_product;

    private String brief;

    private String country;

    private List<String> cities;

    private Boolean guideline;

    private Integer number_short_videos;

    private Integer number_long_videos;

    private Integer number_carrousel;

    private Integer number_creators;

    private CampaignObjective campaign_objective;

    private String delivery;

    private Double price;
}
