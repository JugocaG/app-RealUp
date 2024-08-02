package com.example.RealUpCotizador.db;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "daily_task")
public class DailyTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String op;

    private String task;

    private String comment;

    private Boolean task_completed;
}
