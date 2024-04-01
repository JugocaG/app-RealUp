package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.SaleUGC;
import com.example.RealUpCotizador.dto.SaleUGCDTO;
import com.example.RealUpCotizador.service.SaleUGCService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/api/v1/ugc")
@RestController
public class SaleUGCController {


    SaleUGCService saleUGCService;


    @GetMapping(path = "see-sales")
    public List<SaleUGC> seeSales(){
        return saleUGCService.seeSaleUGC();
    }

    @PostMapping(path = "save-sale")
    public String saveSale(@RequestBody SaleUGCDTO saleUGCDTO){
        saleUGCService.saveSaleUGC(saleUGCDTO);
        return "Se guardo con exito";
    }


}
