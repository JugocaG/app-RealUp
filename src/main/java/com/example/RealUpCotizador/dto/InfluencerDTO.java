package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.db.dataInfluencer.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class InfluencerDTO {
    private String country;

    private String city;

    private String creatorAge;

    private String gender;

    private String name;

    private List<UrlPhoto> urlPhoto;

    private List<UsernameInfluencer> usernameInfluencer;

    private List<UrlSocialMedia> urlSocialMedia;

    private List<Followers> followers;

    private List<PriceActions> priceInfluencer;

    private String contentCategories;

    private String directManagerAgency;

    private String contactPhone;

    private String contactEmail;

    private String languages;

    private List<EngagementRate> engagementRate;

    private List<AudienceGender> audienceMale;

    private List<AudienceGender> audienceFemale;

    private Map<String, List<TopAudienceLocation>> topAudienceCity;

    private Map<String, List<TopAudienceLocation>> topAudienceCountry;

    private Boolean ugc;

    private String teamExperienceComment;

    private Integer teamExperienceRating;
}
