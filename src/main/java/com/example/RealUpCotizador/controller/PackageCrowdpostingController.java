package com.example.RealUpCotizador.controller;

import com.example.RealUpCotizador.db.PackageCrowdpostingInstagram;
import com.example.RealUpCotizador.db.PackageCrowdpostingTikTok;
import com.example.RealUpCotizador.dto.PackageCrowdpostingInstagramDTO;
import com.example.RealUpCotizador.dto.PackageCrowdpostingTikTokDTO;
import com.example.RealUpCotizador.service.PackageCrowdpostingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/crowdposting")
public class PackageCrowdpostingController {


    PackageCrowdpostingService packageCrowdpostingService;


    // Instagram
    @GetMapping(path = "see-packages-instagram")
    public List<PackageCrowdpostingInstagram> seePackages(){
        return packageCrowdpostingService.seePackagesInstagram();
    }

    @PostMapping(path = "save-package-instagram")
    public String savePackageInstagram(@RequestBody List<PackageCrowdpostingInstagramDTO> packageCrowdpostingInstagramDTOS){
        packageCrowdpostingService.savePackagesInstagram(packageCrowdpostingInstagramDTOS);
        return "Se guardo el paquete con exito";
    }

    // TikTok
    @GetMapping(path = "see-packages-tiktok")
    public List<PackageCrowdpostingTikTok> seePackagesTikTok(){
        return packageCrowdpostingService.seePackagesTikTok();
    }

    @PostMapping(path = "save-package-tiktok")
    public String savePackageTikTok(@RequestBody List<PackageCrowdpostingTikTokDTO> packageCrowdpostingTikTokDTOS){
        packageCrowdpostingService.savePackagesTikTok(packageCrowdpostingTikTokDTOS);
        return "Se guardo el paquete con exito";
    }
}
