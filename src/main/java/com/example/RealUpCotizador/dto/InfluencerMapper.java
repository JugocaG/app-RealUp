package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.db.Influencer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfluencerMapper {
    Influencer toEntity(InfluencerDTO influencerDTO);

    InfluencerDTO toDTO(Influencer influencer);
}
