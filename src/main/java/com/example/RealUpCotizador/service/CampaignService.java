package com.example.RealUpCotizador.service;


import com.example.RealUpCotizador.db.Campaign;
import com.example.RealUpCotizador.db.CampaignRepository;
import com.example.RealUpCotizador.dto.CampaignDTO;
import com.example.RealUpCotizador.vo.CampaignState;
import com.example.RealUpCotizador.vo.CampaignType;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CampaignService {

    CampaignRepository campaignRepository;
    TaskCompletedService taskCompletedService;

    public List<Campaign> seeCampaign(){
        return campaignRepository.findAll();
    }

    public Campaign addCampaign(CampaignDTO campaignDTO){
        Campaign campaign = new Campaign();

        campaign.setName(campaignDTO.getName());
        campaign.setInitial_date(campaignDTO.getInitial_date());
        campaign.setFinal_date(campaignDTO.getFinal_date());
        campaign.setTask_completed(campaignDTO.getTask_completed());
        campaign.setName_op(campaignDTO.getName_op());
        campaign.setNumber_contents(campaignDTO.getNumber_contents());
        campaign.setNumber_creators(campaignDTO.getNumber_creators());
        campaign.setCampaign_state(CampaignState.APPROVAL);
        campaign.setBudget(campaignDTO.getBudget());
        campaign.setCampaign_type(campaignDTO.getCampaign_type());
        campaign.setCountry(campaignDTO.getCountry());
        campaign.setPr(campaignDTO.getPr());
        campaign.setImage_url(campaignDTO.getImage_url());

        taskCompletedService.addTaskCompleted(campaignRepository.getLastValueOfCampaignSequence());

        campaignRepository.save(campaign);
        return campaign;

    }

    public void updateCampaign(CampaignDTO campaignDTO){
        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignDTO.getId());
        Campaign campaign = campaignOptional.get();
        campaign.setName(campaignDTO.getName());
        campaign.setInitial_date(campaignDTO.getInitial_date());
        campaign.setFinal_date(campaignDTO.getFinal_date());
        campaign.setName_op(campaignDTO.getName_op());
        campaign.setNumber_contents(campaignDTO.getNumber_contents());
        campaign.setNumber_creators(campaignDTO.getNumber_creators());
        campaign.setBudget(campaignDTO.getBudget());
        campaign.setCampaign_type(campaignDTO.getCampaign_type());
        campaign.setCountry(campaignDTO.getCountry());
        campaign.setPr(campaignDTO.getPr());
        campaign.setImage_url(campaignDTO.getImage_url());

        campaignRepository.save(campaign);

    }
    public List<Campaign> getCampaignsInPreparation() {
        return campaignRepository.findCampaignsByState(CampaignState.PREPARATION);
    }

    public List<Campaign> getCampaignsInExecution() {
        return campaignRepository.findCampaignsByState(CampaignState.EXECUTION);
    }

    public List<Campaign> getCampaignsClosed() {
        return campaignRepository.findCampaignsByState(CampaignState.CLOSED);
    }

    public List<Campaign> getCampaignsProposal() {
        return campaignRepository.findCampaignsByState(CampaignState.APPROVAL);
    }

    public List<Campaign> getCampaignsArchived() {
        return campaignRepository.findCampaignsByState(CampaignState.ARCHIVED);
    }



    public void updateTaskNumber(CampaignDTO campaignDTO, Long idCampaign) {
        Optional<Campaign> campaignOptional = campaignRepository.findById(idCampaign);
        if (campaignOptional.isPresent()) {
            Campaign campaign = campaignOptional.get();
            campaign.setTask_completed(campaignDTO.getTask_completed());

            if (campaign.getTask_completed() > 2){
                campaign.setCampaign_state(CampaignState.PREPARATION);
            }
            if (campaign.getTask_completed() > 6){
                campaign.setCampaign_state(CampaignState.EXECUTION);
            }
            if (campaign.getTask_completed() > 15){
                campaign.setCampaign_state(CampaignState.CLOSED);
            }
            campaignRepository.save(campaign);
        } else {
            // Manejar el caso en que la campaña no se encuentra, por ejemplo, lanzando una excepción
            throw new RuntimeException("Campaign with id " + idCampaign + " not found");
        }
    }

    public Integer getNumberOfContents(Long campaignId) {
        return campaignRepository.findById(campaignId)
                .map(Campaign::getNumber_contents)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + campaignId));
    }

    public void updateCampaignState(Long campaignId, Integer state){
        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignId);

        if (campaignOptional.isPresent()) {
            Campaign campaign = campaignOptional.get();

            if (state == 0){
                campaign.setCampaign_state(CampaignState.PREPARATION);
            }
            if (state == 1){
                campaign.setCampaign_state(CampaignState.EXECUTION);
            }
            if (state == 2){
                campaign.setCampaign_state(CampaignState.CLOSED);
            }
            if (state == 3){
                campaign.setCampaign_state(CampaignState.ARCHIVED);
            }
            if (state == 4){
                campaign.setCampaign_state(CampaignState.APPROVAL);
            }
            if (state == 5){
                campaign.setCampaign_state(CampaignState.DELETED);
            }

            campaignRepository.save(campaign);

        } else {
            // Manejar el caso en que la campaña no se encuentra, por ejemplo, lanzando una excepción
            throw new RuntimeException("Campaign with id " + campaignId + " not found");
        }
    }

    public List<String> getCampaignNamesByNameOp(String nameOp) {
        return campaignRepository.findCampaignNamesByNameOp(nameOp);
    }

}
