package com.example.RealUpCotizador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfluencerDTO {
    private Long id;

    private String country;

    private String city;

    private String creatorAge;

    private String gender;

    private String name;

    private String username;

    private String urlInstagram;

    private String urlTiktok;

    private String urlYoutube;

    private Integer followersInstagram;

    private Integer followersTiktok;

    private Integer followersYoutube;

    private Integer followersTotal;

    private String contentCategories;

    private String directManagerAgency;

    private String contactPhone;

    private String contactEmail;

    private String languages;

    private Double engagementRate;

    private Double audienceMalePercentage;

    private Double audienceFemalePercentage;

    private String top1AudienceCity;

    private String top1AudienceCountry;

    private Boolean ugc;

    private String teamExperienceComment;

    private Integer teamExperienceRating;
}
