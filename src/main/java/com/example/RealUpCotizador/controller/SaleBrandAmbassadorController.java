package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.SaleBrandAmbassador;
import com.example.RealUpCotizador.dto.SaleBrandAmbassadorDTO;
import com.example.RealUpCotizador.service.SaleBrandAmbassadorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping (path = "api/v1/brand-ambassador")
public class SaleBrandAmbassadorController {

    SaleBrandAmbassadorService saleBrandAmbassadorService;

    @GetMapping(path = "see-sales")
    public List<SaleBrandAmbassador> seeSales (){
        return saleBrandAmbassadorService.seeSaleBrandAmbassador();
    }

    @PostMapping(path = "save-sale")
    public String saveSale(@RequestBody SaleBrandAmbassadorDTO saleBrandAmbassadorDTO){
        saleBrandAmbassadorService.saveSaleBrandAmbassador(saleBrandAmbassadorDTO);
        return "La venta se guardo con exito";
    }

}
