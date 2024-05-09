package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.Cities;
import com.example.RealUpCotizador.db.CitiesDTO;
import com.example.RealUpCotizador.db.CitiesRepository;
import com.example.RealUpCotizador.service.CitiesService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
@RequestMapping(path = "/api/v1/cities")
public class CitiesController {

    CitiesRepository citiesRepository;

    CitiesService citiesService;


    @GetMapping(path = "see-cities/{pais}")
    public List<String> seeCities(@PathVariable String pais){
        return citiesService.seeCities(pais);
    }
}
