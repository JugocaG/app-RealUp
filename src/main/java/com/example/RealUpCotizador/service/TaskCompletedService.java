package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.Campaign;
import com.example.RealUpCotizador.db.CampaignRepository;
import com.example.RealUpCotizador.db.TaskCompleted;
import com.example.RealUpCotizador.db.TaskCompletedRepository;
import com.example.RealUpCotizador.dto.TaskCompletedDTO;
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

}
