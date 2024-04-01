package com.example.RealUpCotizador.service;


import com.example.RealUpCotizador.db.SaleUGC;
import com.example.RealUpCotizador.db.SaleUGCRepository;
import com.example.RealUpCotizador.dto.SaleUGCDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleUGCService {

    SaleUGCRepository saleUGCRepository;


    public List<SaleUGC> seeSaleUGC(){
        return saleUGCRepository.findAll();
    }

    public SaleUGC saveSaleUGC(SaleUGCDTO saleUGCDTO){
        SaleUGC saleUGC = new SaleUGC();

        saleUGC.setName_client(saleUGCDTO.getName_client());
        saleUGC.setCampaign_name(saleUGCDTO.getCampaign_name());
        saleUGC.setType_product(saleUGCDTO.getType_product());
        saleUGC.setName_product(saleUGCDTO.getName_product());
        saleUGC.setBrief(saleUGCDTO.getBrief());
        saleUGC.setCountry(saleUGCDTO.getCountry());
        saleUGC.setCities(saleUGCDTO.getCities());
        saleUGC.setGuideline(saleUGCDTO.getGuideline());
        saleUGC.setNumber_carrousel(saleUGCDTO.getNumber_carrousel());
        saleUGC.setNumber_long_videos(saleUGCDTO.getNumber_long_videos());
        saleUGC.setNumber_short_videos(saleUGCDTO.getNumber_short_videos());
        saleUGC.setNumber_creators(saleUGCDTO.getNumber_creators());
        saleUGC.setPrice((saleUGC.getNumber_creators()*100)+(saleUGC.getNumber_creators()*100*0.15));
        saleUGC.setDelivery(saleUGCDTO.getDelivery());
        saleUGC.setCampaign_objective(saleUGCDTO.getCampaign_objective());

        saleUGCRepository.save(saleUGC);
        return saleUGC;

    }
}
