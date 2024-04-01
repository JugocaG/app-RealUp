package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.SaleBrandAmbassador;
import com.example.RealUpCotizador.db.SaleBrandAmbassadorRepository;
import com.example.RealUpCotizador.dto.SaleBrandAmbassadorDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleBrandAmbassadorService {

    SaleBrandAmbassadorRepository saleBrandAmbassadorRepository;

    public List<SaleBrandAmbassador> seeSaleBrandAmbassador(){
        return saleBrandAmbassadorRepository.findAll();
    }

    public SaleBrandAmbassador saveSaleBrandAmbassador(SaleBrandAmbassadorDTO saleBrandAmbassadorDTO){
        SaleBrandAmbassador saleBrandAmbassador = new SaleBrandAmbassador();

        saleBrandAmbassador.setClient(saleBrandAmbassadorDTO.getClient());
        saleBrandAmbassador.setCampaign_name(saleBrandAmbassadorDTO.getCampaign_name());
        saleBrandAmbassador.setCampaign_objective(saleBrandAmbassadorDTO.getCampaign_objective());
        saleBrandAmbassador.setLocation(saleBrandAmbassadorDTO.getLocation());
        saleBrandAmbassador.setCities(saleBrandAmbassadorDTO.getCities());
        saleBrandAmbassador.setAudience_interests(saleBrandAmbassadorDTO.getAudience_interests());
        saleBrandAmbassador.setAudience_language(saleBrandAmbassadorDTO.getAudience_language());
        saleBrandAmbassador.setAudience_ages(saleBrandAmbassadorDTO.getAudience_ages());
        saleBrandAmbassador.setAudience_genders(saleBrandAmbassadorDTO.getAudience_genders());
        saleBrandAmbassador.setContent_type(saleBrandAmbassadorDTO.getContent_type());
        saleBrandAmbassador.setDate_publish(saleBrandAmbassadorDTO.getDate_publish());
        saleBrandAmbassador.setMinimum_followers(saleBrandAmbassadorDTO.getMinimum_followers());

        saleBrandAmbassadorRepository.save(saleBrandAmbassador);
        return saleBrandAmbassador;
    }

}
