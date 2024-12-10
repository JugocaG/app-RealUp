package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.db.converter.*;
import com.example.RealUpCotizador.db.dataInfluencer.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
@Entity
@Table(name = "influencer")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "influencer_sequence")
    @SequenceGenerator(name = "influencer_sequence", sequenceName = "influencer_sequence", allocationSize = 1, initialValue = 10000)
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "creator_age")
    private String creatorAge;

    @Column(name = "gender")
    private String gender;

    @Column(name = "name")
    private String name;

    @Column(name = "url_photo", columnDefinition = "json")
    @Convert(converter = UrlPhotoConverter.class)
    private List<UrlPhoto> urlPhoto;

    @Column(name = "username_influencer", columnDefinition = "json")
    @Convert(converter = UsernameInfluencerConverter.class)
    private List<UsernameInfluencer> usernameInfluencer;

    @Column(name = "url_social_media", columnDefinition = "json")
    @Convert(converter = UrlSocialMediaConverter.class)
    private List<UrlSocialMedia> urlSocialMedia;

    @Column(name = "followers", columnDefinition = "json")
    @Convert(converter = FollowersConverter.class)
    private List<Followers> followers;

    @Column(name = "price_influencer", columnDefinition = "json")
    @Convert(converter = PriceActionsConverter.class)
    private List<PriceActions> priceInfluencer;

    @Column(name = "content_categories")
    private String contentCategories;

    @Column(name = "direct_manager_agency")
    private String directManagerAgency;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "languages")
    private String languages;

    @Column(name = "engagement_rate", columnDefinition = "json")
    @Convert(converter = EngagementRateConverter.class)
    private List<EngagementRate> engagementRate;

    @Column(name = "audience_male", columnDefinition = "json")
    @Convert(converter = AudienceGenderConverter.class)
    private List<AudienceGender> audienceMale;

    @Column(name = "audience_female", columnDefinition = "json")
    @Convert(converter = AudienceGenderConverter.class)
    private List<AudienceGender> audienceFemale;


    @Column(name = "top_audience_city", columnDefinition = "json")
    @Convert(converter = TopAudienceLocationConverter.class)
    private Map<String, List<TopAudienceLocation>> topAudienceCity;


    @Column(name = "top_audience_country", columnDefinition = "json")
    @Convert(converter = TopAudienceLocationConverter.class)
    private Map<String, List<TopAudienceLocation>> topAudienceCountry;

    @Column(name = "ugc", columnDefinition = "BOOLEAN")
    private Boolean ugc;

    @Column(name = "team_experience_comment", columnDefinition = "TEXT")
    private String teamExperienceComment;

    @Column(name = "team_experience_rating")
    private Integer teamExperienceRating;
}

