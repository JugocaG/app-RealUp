package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.Cities;
import com.example.RealUpCotizador.db.CitiesDTO;
import com.example.RealUpCotizador.db.CitiesRepository;
import com.example.RealUpCotizador.db.PackageCrowdpostingInstagram;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CitiesService {

    CitiesRepository citiesRepository;


    public List<String> seeCities(String pais){
//        return citiesRepository.findCitiesByCountry(pais);
        List<Cities> ciudadesProyectadas = citiesRepository.findCitiesByCountry(pais);
        return ciudadesProyectadas.stream()
                .map(Cities::getCity_ascii)
                .sorted()
                .collect(Collectors.toList());
    }
}
