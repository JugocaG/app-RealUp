package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.vo.TypeSocialMedia;
import lombok.Data;

@Data
public class PackageCrowdpostingTikTokDTO {
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
