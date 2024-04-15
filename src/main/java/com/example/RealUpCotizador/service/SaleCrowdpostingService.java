package com.example.RealUpCotizador.service;
import com.example.RealUpCotizador.db.SaleCrowdposting;
import com.example.RealUpCotizador.db.SaleCrowdpostingRepository;
import com.example.RealUpCotizador.dto.SaleCrowdpostingDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleCrowdpostingService {

    private SaleCrowdpostingRepository saleCrowdpostingRepository;

    public List<SaleCrowdposting> seeSalesCrowdposting(){
        return saleCrowdpostingRepository.findAll();
    }

    public SaleCrowdposting saveSaleCrowdposting(SaleCrowdpostingDTO saleCrowdpostingDTO){
        SaleCrowdposting saleCrowdposting = new SaleCrowdposting();

        saleCrowdposting.setName_client(saleCrowdpostingDTO.getName_client());
        saleCrowdposting.setReach(saleCrowdpostingDTO.getReach());
        saleCrowdposting.setCountry(saleCrowdpostingDTO.getCountry());
        saleCrowdposting.setCities(saleCrowdpostingDTO.getCities());
        saleCrowdposting.setNumber_cities(saleCrowdpostingDTO.getCities().size());
        saleCrowdposting.setPrice(saleCrowdpostingDTO.getPrice());
        saleCrowdposting.setCampaign_objective(saleCrowdpostingDTO.getCampaign_objective());

        saleCrowdpostingRepository.save(saleCrowdposting);
        return saleCrowdposting;
    }


}
