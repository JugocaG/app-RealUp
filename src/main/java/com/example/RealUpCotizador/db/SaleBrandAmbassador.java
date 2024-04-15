package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.vo.CampaignObjective;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "sale_brand_ambassador")
public class SaleBrandAmbassador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_brand_ambassador_sequence")
    @SequenceGenerator(name = "sale_brand_ambassador_sequence", sequenceName = "sale_brand_ambassador_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String client;

    private String campaign_name;

    private CampaignObjective campaign_objective;

    private String brief_campaign_objective;

    private String location;

    @ElementCollection
    private List<String> cities;

    @ElementCollection
    private List<String> audience_interests;

    private String audience_language;

    private String audience_ages;

    private String audience_genders;

    @ElementCollection
    private List<String> content_type;

    private String creator_gender;

    private String brief_video_content;

    private String date_publish;

    @ElementCollection
    private List<String> minimum_followers;

    private Integer number_creators;

}
