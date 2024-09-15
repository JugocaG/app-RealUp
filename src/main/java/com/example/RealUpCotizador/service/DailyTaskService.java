package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.DailyTask;
import com.example.RealUpCotizador.db.DailyTaskRepository;
import com.example.RealUpCotizador.dto.DailyTaskDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DailyTaskService {

    DailyTaskRepository dailyTaskRepository;

    public List<DailyTask> seeDailyTask(){
        return dailyTaskRepository.findAll();
    }

    public DailyTask addDailyTask(DailyTaskDTO dailyTaskDTO){
        DailyTask dailyTask = new DailyTask();

        dailyTask.setOp(dailyTaskDTO.getOp());
        dailyTask.setTask(dailyTaskDTO.getTask());
        dailyTask.setComment(dailyTaskDTO.getComment());
        dailyTask.setTask_completed(false);
        dailyTask.setTitleTask(dailyTaskDTO.getTitleTask());
        ZonedDateTime currentDateTime = ZonedDateTime.now().withHour(18).withMinute(0).withSecond(0).withNano(0);
        dailyTask.setDateTask(currentDateTime);
        dailyTask.setNameCampaign(dailyTaskDTO.getNameCampaign());
        dailyTask.setOrder_task(0);

        dailyTaskRepository.save(dailyTask);
        return dailyTask;
    }

    public DailyTask updateDailyTask(DailyTaskDTO dailyTaskDTO){
        Optional<DailyTask> dailyTaskOptional = dailyTaskRepository.findById(dailyTaskDTO.getId());
        DailyTask dailyTask = dailyTaskOptional.get();
        dailyTask.setTask(dailyTaskDTO.getTask());
        dailyTask.setComment(dailyTaskDTO.getComment());
        dailyTask.setTask_completed(dailyTaskDTO.getTask_completed());
        dailyTask.setOrder_task(dailyTaskDTO.getOrder_task());
        dailyTask.setTitleTask(dailyTaskDTO.getTitleTask());
        dailyTask.setDateTask(dailyTaskDTO.getDateTask());
        dailyTask.setNameCampaign(dailyTaskDTO.getNameCampaign());

        dailyTaskRepository.save(dailyTask);
        return dailyTask;
    }

    public List<DailyTask> seeOpTask(DailyTaskDTO dailyTaskDTO){
        List<DailyTask> dailyTaskList = dailyTaskRepository.findByOp(dailyTaskDTO.getOp());
        return dailyTaskList;
    }

    public void deleteDailyTask(DailyTaskDTO dailyTaskDTO){
        dailyTaskRepository.deleteById(dailyTaskDTO.getId());
    }

    public List<DailyTask> getTitleTask(DailyTaskDTO dailyTaskDTO){
        List<DailyTask> dailyTaskList = dailyTaskRepository.findByOpAndTitleTask(dailyTaskDTO.getOp(), dailyTaskDTO.getTitleTask());
        return dailyTaskList;
    }

    public DailyTask updateDailyTaskTitle(DailyTaskDTO dailyTaskDTO){
        Optional<DailyTask> dailyTaskOptional = dailyTaskRepository.findById(dailyTaskDTO.getId());
        DailyTask dailyTask = dailyTaskOptional.get();

        dailyTask.setOrder_task(dailyTaskDTO.getOrder_task());

        dailyTaskRepository.save(dailyTask);
        return dailyTask;
    }

    public void updateDailyTasks(List<DailyTaskDTO> dailyTaskDTOs) {
        for (DailyTaskDTO dailyTaskDTO : dailyTaskDTOs) {
            // Buscar la entidad correspondiente por ID en la base de datos
            DailyTask dailyTaskEntity = dailyTaskRepository.findById(dailyTaskDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + dailyTaskDTO.getId()));

            // Actualizar los campos con los datos del DTO
            dailyTaskEntity.setOp(dailyTaskDTO.getOp());
            dailyTaskEntity.setTask(dailyTaskDTO.getTask());
            dailyTaskEntity.setComment(dailyTaskDTO.getComment());
            dailyTaskEntity.setTask_completed(dailyTaskDTO.getTask_completed());
            dailyTaskEntity.setOrder_task(dailyTaskDTO.getOrder_task());
            dailyTaskEntity.setTitleTask(dailyTaskDTO.getTitleTask());
            dailyTaskEntity.setNameCampaign(dailyTaskDTO.getNameCampaign());
            dailyTaskEntity.setDateTask(dailyTaskDTO.getDateTask()); // ZonedDateTime es compatible

            // Guardar la entidad actualizada
            dailyTaskRepository.save(dailyTaskEntity);
        }
    }


}
