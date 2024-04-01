package com.example.RealUpCotizador.controller;
import com.example.RealUpCotizador.db.SaleCrowdposting;
import com.example.RealUpCotizador.db.SaleCrowdpostingRepository;
import com.example.RealUpCotizador.dto.SaleCrowdpostingDTO;
import com.example.RealUpCotizador.service.SaleCrowdpostingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "/api/v1/crowdposting")
public class SaleCrowdpostingController {

    final Integer SUBTRACT_LAST_NUMBER_SEQUENCE = 1;

    SaleCrowdpostingService saleCrowdpostingService;

    SaleCrowdpostingRepository saleCrowdpostingRepository;

    @GetMapping(path = "see-sales")
    public List<SaleCrowdposting> seeSale() {
        return saleCrowdpostingService.seeSalesCrowdposting();
    }

    @PostMapping(path = "save-sale")
    public String saveSale(@RequestBody SaleCrowdpostingDTO saleCrowdpostingDTO){
        saleCrowdpostingService.saveSaleCrowdposting(saleCrowdpostingDTO);
        log.info("Sale No. " + (saleCrowdpostingRepository.getNextValSale() - SUBTRACT_LAST_NUMBER_SEQUENCE) + ". Name client: " + saleCrowdpostingDTO.getName_client() + ". Reach: " + saleCrowdpostingDTO.getReach() + ". Country: " + saleCrowdpostingDTO.getCountry() + ". Number Cities: " + saleCrowdpostingDTO.getNumber_cities() + ". Has been saved");
        return null;
    }

}
