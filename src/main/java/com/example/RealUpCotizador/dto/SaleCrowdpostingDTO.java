package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.vo.CampaignObjective;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SaleCrowdpostingDTO {

    private String name_client;

    private Integer reach;

    private String country;

    private Integer number_cities;

    private CampaignObjective campaign_objective;

    private Long price;
}
