package com.example.RealUpCotizador.dto;

import lombok.Data;

@Data
public class DailyTaskDTO {
    private Long id;

    private String op;

    private String task;

    private String comment;

    private Boolean task_completed;

    private Integer order_task;

    private String titleTask;

}
