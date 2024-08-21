package com.example.RealUpCotizador.service;


import com.example.RealUpCotizador.db.WeeklyWorkload;
import com.example.RealUpCotizador.db.WeeklyWorkloadRepository;
import com.example.RealUpCotizador.dto.WeeklyWorkloadDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class WeeklyWorkloadService {

    WeeklyWorkloadRepository weeklyWorkloadRepository;


    public WeeklyWorkload getWeeklyLoad(){
        Long longNumber = (long) 1;
        Optional<WeeklyWorkload> weeklyWorkloadOptional = weeklyWorkloadRepository.findById(longNumber);
        if (weeklyWorkloadOptional.isPresent()){
            return weeklyWorkloadOptional.get();

        }
        else {
            throw new RuntimeException("Campaign not found");
        }
    }

    public void addWeeklyLoad(){
        WeeklyWorkload weeklyWorkload = new WeeklyWorkload();

        weeklyWorkload.setContents_no_pr_daniela(0);
        weeklyWorkload.setContents_pr_daniela(0);
        weeklyWorkload.setCampaign_preparation_daniela(0);
        weeklyWorkload.setCampaign_active_daniela(0);
        weeklyWorkload.setProfiles_no_pr_daniela(0);
        weeklyWorkload.setProfiles_pr_daniela(0);

        weeklyWorkload.setContents_no_pr_estefany(0);
        weeklyWorkload.setContents_pr_estefany(0);
        weeklyWorkload.setCampaign_preparation_estefany(0);
        weeklyWorkload.setCampaign_active_estefany(0);
        weeklyWorkload.setProfiles_no_pr_estefany(0);
        weeklyWorkload.setProfiles_pr_estefany(0);

        weeklyWorkload.setContents_no_pr_luisa(0);
        weeklyWorkload.setContents_pr_luisa(0);
        weeklyWorkload.setCampaign_preparation_luisa(0);
        weeklyWorkload.setCampaign_active_luisa(0);
        weeklyWorkload.setProfiles_no_pr_luisa(0);
        weeklyWorkload.setProfiles_pr_luisa(0);

        weeklyWorkloadRepository.save(weeklyWorkload);
    }

    public void updateWeeklyLoad(WeeklyWorkloadDTO weeklyWorkloadDTO){
        Long longNumber = (long) 1;
        Optional<WeeklyWorkload> weeklyWorkloadOptional = weeklyWorkloadRepository.findById(longNumber);
        WeeklyWorkload weeklyWorkload = weeklyWorkloadOptional.get();

        weeklyWorkload.setContents_no_pr_daniela(weeklyWorkloadDTO.getContents_no_pr_daniela());
        weeklyWorkload.setContents_pr_daniela(weeklyWorkloadDTO.getContents_pr_daniela());
        weeklyWorkload.setCampaign_preparation_daniela(weeklyWorkloadDTO.getCampaign_preparation_daniela());
        weeklyWorkload.setCampaign_active_daniela(weeklyWorkloadDTO.getCampaign_active_daniela());
        weeklyWorkload.setProfiles_no_pr_daniela(weeklyWorkloadDTO.getProfiles_no_pr_daniela());
        weeklyWorkload.setProfiles_pr_daniela(weeklyWorkloadDTO.getProfiles_pr_daniela());

        weeklyWorkload.setContents_no_pr_estefany(weeklyWorkloadDTO.getContents_no_pr_estefany());
        weeklyWorkload.setContents_pr_estefany(weeklyWorkloadDTO.getContents_pr_estefany());
        weeklyWorkload.setCampaign_preparation_estefany(weeklyWorkloadDTO.getCampaign_preparation_estefany());
        weeklyWorkload.setCampaign_active_estefany(weeklyWorkloadDTO.getCampaign_active_estefany());
        weeklyWorkload.setProfiles_no_pr_estefany(weeklyWorkloadDTO.getProfiles_no_pr_estefany());
        weeklyWorkload.setProfiles_pr_estefany(weeklyWorkloadDTO.getProfiles_pr_estefany());

        weeklyWorkload.setContents_no_pr_luisa(weeklyWorkloadDTO.getContents_no_pr_luisa());
        weeklyWorkload.setContents_pr_luisa(weeklyWorkloadDTO.getContents_pr_luisa());
        weeklyWorkload.setCampaign_preparation_luisa(weeklyWorkloadDTO.getCampaign_preparation_luisa());
        weeklyWorkload.setCampaign_active_luisa(weeklyWorkloadDTO.getCampaign_active_luisa());
        weeklyWorkload.setProfiles_no_pr_luisa(weeklyWorkloadDTO.getProfiles_no_pr_luisa());
        weeklyWorkload.setProfiles_pr_luisa(weeklyWorkloadDTO.getProfiles_pr_luisa());

        weeklyWorkloadRepository.save(weeklyWorkload);
    }
}
