package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.vo.CampaignObjective;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class SaleBrandAmbassadorDTO {

    private String client;

    private String campaign_name;

    private CampaignObjective campaign_objective;

    private String brief_campaign_objective;

    private String location;

    private List<String> cities;

    private List<String> audience_interests;

    private String audience_language;

    private String audience_ages;

    private String audience_genders;

    private List<String> content_type;

    private String creator_gender;

    private String brief_video_content;

    private String date_publish;

    private List<String> minimum_followers;

    private Integer number_creators;

}
