package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.Campaign;
import com.example.RealUpCotizador.db.CampaignRepository;
import com.example.RealUpCotizador.db.TaskCompleted;
import com.example.RealUpCotizador.db.TaskCompletedRepository;
import com.example.RealUpCotizador.dto.TaskCompletedDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class TaskCompletedService {

    TaskCompletedRepository taskCompletedRepository;

    CampaignRepository campaignRepository;

    public List<TaskCompleted> seeTaskCompleted(){
        return taskCompletedRepository.findAll();
    }
    public TaskCompleted getTaskCompleted(Long idCampaign){
        return taskCompletedRepository.findByIdCampaign(idCampaign);
    }

    public TaskCompleted addTaskCompleted(Long idCampaign){
        TaskCompleted taskCompleted = new TaskCompleted();
        taskCompleted.setIdCampaign(idCampaign);

        taskCompleted.setLink_task_2("");
        taskCompleted.setLink_task_4("");
        taskCompleted.setLink_task_5("");
        taskCompleted.setLink_task_7("");
        taskCompleted.setLink_task_9("");
        taskCompleted.setLink_task_16("");
        taskCompleted.setLink_task_18("");

        taskCompleted.setTask_1(false);
        taskCompleted.setTask_2(false);
        taskCompleted.setTask_3(false);
        taskCompleted.setTask_4(false);
        taskCompleted.setTask_5(false);
        taskCompleted.setTask_6(false);
        taskCompleted.setTask_7(false);
        taskCompleted.setTask_8(false);
        taskCompleted.setTask_9(false);
        taskCompleted.setTask_10(false);
        taskCompleted.setTask_11(false);
        taskCompleted.setTask_12(false);
        taskCompleted.setTask_13(false);
        taskCompleted.setTask_14(false);
        taskCompleted.setTask_15(false);
        taskCompleted.setTask_16(false);
        taskCompleted.setTask_17(false);
        taskCompleted.setTask_18(false);
        taskCompleted.setContent_completed(0);
        taskCompletedRepository.save(taskCompleted);
        return taskCompleted;
    }

    public void updateChecklist(Long idCampaign, TaskCompletedDTO taskCompletedDTO) {
        TaskCompleted taskCompleted = taskCompletedRepository.findByIdCampaign(idCampaign);

        taskCompleted.setTask_1(taskCompletedDTO.getTask_1());
        taskCompleted.setTask_2(taskCompletedDTO.getTask_2());
        taskCompleted.setTask_3(taskCompletedDTO.getTask_3());
        taskCompleted.setTask_4(taskCompletedDTO.getTask_4());
        taskCompleted.setTask_5(taskCompletedDTO.getTask_5());
        taskCompleted.setTask_6(taskCompletedDTO.getTask_6());
        taskCompleted.setTask_7(taskCompletedDTO.getTask_7());
        taskCompleted.setTask_8(taskCompletedDTO.getTask_8());
        taskCompleted.setTask_9(taskCompletedDTO.getTask_9());
        taskCompleted.setTask_10(taskCompletedDTO.getTask_10());
        taskCompleted.setTask_11(taskCompletedDTO.getTask_11());
        taskCompleted.setTask_12(taskCompletedDTO.getTask_12());
        taskCompleted.setTask_13(taskCompletedDTO.getTask_13());
        taskCompleted.setTask_14(taskCompletedDTO.getTask_14());
        taskCompleted.setTask_15(taskCompletedDTO.getTask_15());
        taskCompleted.setTask_16(taskCompletedDTO.getTask_16());
        taskCompleted.setTask_17(taskCompletedDTO.getTask_17());
        taskCompleted.setTask_18(taskCompletedDTO.getTask_18());
        taskCompleted.setNumber_task_completed(taskCompletedDTO.getNumber_task_completed());

        taskCompletedRepository.save(taskCompleted);
    }
    public void updateContentChecklist(Long idCampaign, TaskCompletedDTO taskCompletedDTO) {
        TaskCompleted taskCompleted = taskCompletedRepository.findByIdCampaign(idCampaign);

        taskCompleted.setComment_task_1(taskCompletedDTO.getComment_task_1());
        taskCompleted.setComment_task_2(taskCompletedDTO.getComment_task_2());
        taskCompleted.setComment_task_3(taskCompletedDTO.getComment_task_3());
        taskCompleted.setComment_task_4(taskCompletedDTO.getComment_task_4());
        taskCompleted.setComment_task_5(taskCompletedDTO.getComment_task_5());
        taskCompleted.setComment_task_6(taskCompletedDTO.getComment_task_6());
        taskCompleted.setComment_task_7(taskCompletedDTO.getComment_task_7());
        taskCompleted.setComment_task_8(taskCompletedDTO.getComment_task_8());
        taskCompleted.setComment_task_9(taskCompletedDTO.getComment_task_9());
        taskCompleted.setComment_task_10(taskCompletedDTO.getComment_task_10());
        taskCompleted.setComment_task_11(taskCompletedDTO.getComment_task_11());
        taskCompleted.setComment_task_12(taskCompletedDTO.getComment_task_12());
        taskCompleted.setComment_task_13(taskCompletedDTO.getComment_task_13());
        taskCompleted.setComment_task_14(taskCompletedDTO.getComment_task_14());
        taskCompleted.setComment_task_15(taskCompletedDTO.getComment_task_15());
        taskCompleted.setComment_task_16(taskCompletedDTO.getComment_task_16());
        taskCompleted.setComment_task_17(taskCompletedDTO.getComment_task_17());
        taskCompleted.setComment_task_18(taskCompletedDTO.getComment_task_18());

        taskCompleted.setLink_task_2(taskCompletedDTO.getLink_task_2());
        taskCompleted.setLink_task_4(taskCompletedDTO.getLink_task_4());
        taskCompleted.setLink_task_5(taskCompletedDTO.getLink_task_5());
        taskCompleted.setLink_task_7(taskCompletedDTO.getLink_task_7());
        taskCompleted.setLink_task_9(taskCompletedDTO.getLink_task_9());
        taskCompleted.setLink_task_16(taskCompletedDTO.getLink_task_16());
        taskCompleted.setLink_task_18(taskCompletedDTO.getLink_task_18());

        taskCompleted.setContent_completed(taskCompletedDTO.getContent_completed());

        taskCompletedRepository.save(taskCompleted);

        Optional<Campaign> campaignOptional = campaignRepository.findById(idCampaign);

        Campaign campaign = campaignOptional.get();
        campaign.setNumber_contents_done(taskCompletedDTO.getContent_completed());
        campaignRepository.save(campaign);

    }

    public Integer getNumberOfContentsCampaign(Long checkListId) {

        return taskCompletedRepository.findById(checkListId)
                .map(TaskCompleted::getContent_completed)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found with id: " + checkListId));
    }
}
