package com.example.RealUpCotizador.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
public class TaskCompleted {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_completed_sequence")
    @SequenceGenerator(name = "task_completed_sequence", sequenceName = "task_completed_sequence", allocationSize = 1, initialValue = 2000)
    private Long id;

    private Long idCampaign;

    private Boolean task_1;

    private String comment_task_1;

    private Boolean task_2;

    private String link_task_2;

    private String comment_task_2;

    private Boolean task_3;

    private String comment_task_3;

    private Boolean task_4;

    private String link_task_4;

    private String comment_task_4;

    private Boolean task_5;

    private String comment_task_5;

    private String link_task_5;

    private Boolean task_6;

    private String comment_task_6;

    private Boolean task_7;

    private String link_task_7;

    private String comment_task_7;

    private Boolean task_8;

    private String comment_task_8;

    private Boolean task_9;

    private String link_task_9;

    private String comment_task_9;

    private Boolean task_10;

    private String comment_task_10;

    private Boolean task_11;

    private String comment_task_11;

    private Boolean task_12;

    private String comment_task_12;

    private Boolean task_13;

    private String comment_task_13;

    private Boolean task_14;

    private String comment_task_14;

    private Boolean task_15;

    private String comment_task_15;

    private Boolean task_16;

    private String link_task_16;

    private String comment_task_16;

    private Boolean task_17;

    private String comment_task_17;

    private Boolean task_18;

    private String link_task_18;

    private String comment_task_18;

    private Integer number_task_completed;

}
