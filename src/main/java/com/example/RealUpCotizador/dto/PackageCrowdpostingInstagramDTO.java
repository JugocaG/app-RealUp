package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.vo.TypeSocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PackageCrowdpostingInstagramDTO {

    private String country;

    private Integer number_nano;

    private Integer number_micro;

    private Integer number_reels_nano;

    private Integer number_stories_nano;

    private Integer number_reels_micro;

    private Integer number_stories_micro;

    private Integer price;

    private Integer reach_package;

    private Integer cpv;
}
