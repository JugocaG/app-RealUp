package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.*;
import com.example.RealUpCotizador.dto.PackageCrowdpostingInstagramDTO;
import com.example.RealUpCotizador.dto.PackageCrowdpostingTikTokDTO;
import com.example.RealUpCotizador.vo.TypeSocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PackageCrowdpostingService {

    PackageCrowdpostingInstagramRepository packageCrowdpostingInstagramRepository;

    PackageCrowdpostingTikTokRepository packageCrowdpostingTikTokRepository;

    SaleCrowdpostingRepository saleCrowdpostingRepository;


    public List<PackageCrowdpostingInstagram> seePackagesInstagram(){
        return packageCrowdpostingInstagramRepository.findAll();
    }

    public List<PackageCrowdpostingInstagram> savePackagesInstagram(List<PackageCrowdpostingInstagramDTO> packageCrowdpostingInstagramDTOs) {
        List<PackageCrowdpostingInstagram> savedPackages = packageCrowdpostingInstagramDTOs.stream()
                .map(dto -> convertToEntityInstagram(dto))
                .map(entity -> packageCrowdpostingInstagramRepository.save(entity))
                .collect(Collectors.toList());
        return savedPackages;
    }

    private PackageCrowdpostingInstagram convertToEntityInstagram(PackageCrowdpostingInstagramDTO dto) {
        PackageCrowdpostingInstagram entityInstagram = new PackageCrowdpostingInstagram();
        entityInstagram.setCountry(dto.getCountry());
        entityInstagram.setId_sale(saleCrowdpostingRepository.getLastValSale());
        entityInstagram.setDescription_contents(
                "Quantity Nano Creators: " + dto.getNumber_nano() + " " +
                        "Quantity Reels Nano: " + dto.getNumber_reels_nano() + " " +
                        "Quantity Stories Nano: " + dto.getNumber_stories_nano() + " " +
                        "Quantity Micro Creators: " + dto.getNumber_micro() + " " +
                        "Quantity Reels Micro: " + dto.getNumber_reels_micro() + " " +
                        "Quantity Stories Micro: " + dto.getNumber_stories_micro() + "."
        );
        entityInstagram.setNumber_contents((dto.getNumber_micro() * (dto.getNumber_reels_micro() + dto.getNumber_stories_micro())) +
                (dto.getNumber_nano() * (dto.getNumber_reels_nano() + dto.getNumber_stories_nano())));
        entityInstagram.setNumber_nano(dto.getNumber_nano());
        entityInstagram.setNumber_micro(dto.getNumber_micro());
        entityInstagram.setNumber_reels_micro(dto.getNumber_reels_micro());
        entityInstagram.setNumber_stories_micro(dto.getNumber_stories_micro());
        entityInstagram.setNumber_reels_nano(dto.getNumber_reels_nano());
        entityInstagram.setNumber_stories_nano(dto.getNumber_stories_nano());
        entityInstagram.setPrice(dto.getPrice());
        entityInstagram.setReach_package(dto.getReach_package());
        entityInstagram.setCpv(dto.getCpv());
        entityInstagram.setSocial_media(TypeSocialMedia.INSTAGRAM);
        return entityInstagram;
    }

    //TikTok

    public List<PackageCrowdpostingTikTok> seePackagesTikTok(){
        return packageCrowdpostingTikTokRepository.findAll();
    }

    public List<PackageCrowdpostingTikTok> savePackagesTikTok(List<PackageCrowdpostingTikTokDTO> packageCrowdpostingTikTokDTOs) {
        List<PackageCrowdpostingTikTok> savedPackages = packageCrowdpostingTikTokDTOs.stream()
                .map(dto -> convertToEntityTikTok(dto))
                .map(entity -> packageCrowdpostingTikTokRepository.save(entity))
                .collect(Collectors.toList());
        return savedPackages;
    }

    private PackageCrowdpostingTikTok convertToEntityTikTok(PackageCrowdpostingTikTokDTO dto) {
        PackageCrowdpostingTikTok entityTikTok = new PackageCrowdpostingTikTok();
        entityTikTok.setCountry(dto.getCountry());
        entityTikTok.setId_sale(saleCrowdpostingRepository.getLastValSale());
        entityTikTok.setDescription_contents(
                "Quantity Nano Creators: " + dto.getNumber_nano() + " " +
                        "Quantity TikTok Nano: " + dto.getNumber_tiktok_nano() + " " +
                        "Quantity Micro Creators: " + dto.getNumber_micro() + " " +
                        "Quantity TikTok Micro: " + dto.getNumber_tiktok_micro() + "."
        );
        entityTikTok.setNumber_contents((dto.getNumber_micro() * (dto.getNumber_tiktok_micro())) +
                (dto.getNumber_nano() * (dto.getNumber_tiktok_nano())));
        entityTikTok.setNumber_nano(dto.getNumber_nano());
        entityTikTok.setNumber_micro(dto.getNumber_micro());
        entityTikTok.setNumber_tiktok_micro(dto.getNumber_tiktok_micro());
        entityTikTok.setNumber_tiktok_nano(dto.getNumber_tiktok_nano());
        entityTikTok.setPrice(dto.getPrice());
        entityTikTok.setReach_package(dto.getReach_package());
        entityTikTok.setCpv(dto.getCpv());
        entityTikTok.setSocial_media(TypeSocialMedia.TIKTOK);
        return entityTikTok;
    }

}
