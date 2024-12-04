package com.example.RealUpCotizador.db;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "username")
    private String username;

    @Column(name = "url_instagram", columnDefinition = "TEXT")
    private String urlInstagram;

    @Column(name = "url_tiktok", columnDefinition = "TEXT")
    private String urlTiktok;

    @Column(name = "url_youtube", columnDefinition = "TEXT")
    private String urlYoutube;

    @Column(name = "followers_instagram")
    private Integer followersInstagram;

    @Column(name = "followers_tiktok")
    private Integer followersTiktok;

    @Column(name = "followers_youtube")
    private Integer followersYoutube;

    @Column(name = "followers_total")
    private Integer followersTotal;

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

    @Column(name = "engagement_rate")
    private Double engagementRate;

    @Column(name = "audience_male_percentage")
    private Double audienceMalePercentage;

    @Column(name = "audience_female_percentage")
    private Double audienceFemalePercentage;

    @Column(name = "top1_audience_city")
    private String top1AudienceCity;

    @Column(name = "top1_audience_country")
    private String top1AudienceCountry;

    @Column(name = "ugc", columnDefinition = "BOOLEAN")
    private Boolean ugc;

    @Column(name = "team_experience_comment", columnDefinition = "TEXT")
    private String teamExperienceComment;

    @Column(name = "team_experience_rating")
    private Integer teamExperienceRating;
}
