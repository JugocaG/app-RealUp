package com.example.RealUpCotizador.service;

import com.example.RealUpCotizador.db.DailyTask;
import com.example.RealUpCotizador.db.DailyTaskRepository;
import com.example.RealUpCotizador.dto.DailyTaskDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        dailyTaskRepository.save(dailyTask);
        return dailyTask;

    }

    public DailyTask updateDailyTask(DailyTaskDTO dailyTaskDTO){
        Optional<DailyTask> dailyTaskOptional = dailyTaskRepository.findById(dailyTaskDTO.getId());
        DailyTask dailyTask = dailyTaskOptional.get();
        dailyTask.setTask(dailyTaskDTO.getTask());
        dailyTask.setComment(dailyTaskDTO.getComment());
        dailyTask.setTask_completed(dailyTaskDTO.getTask_completed());
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
}
