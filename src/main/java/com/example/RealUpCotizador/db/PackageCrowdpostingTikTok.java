package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.vo.TypeSocialMedia;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "package_crowdposting_tiktok")
public class PackageCrowdpostingTikTok {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "package_crowdposting_tiktok_sequence")
    @SequenceGenerator(name = "package_crowdposting_tiktok_sequence", sequenceName = "package_crowdposting_tiktok_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private Long id_sale;

    private String country;

    private String description_contents;

    private Integer number_contents;

    private Integer number_nano;

    private Integer number_micro;

    private Integer number_tiktok_nano;

    private Integer number_tiktok_micro;

    private Integer price;

    private Integer reach_package;

    private Integer cpv;

    private TypeSocialMedia social_media;
}
