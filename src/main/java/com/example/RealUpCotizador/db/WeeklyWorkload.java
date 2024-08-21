package com.example.RealUpCotizador.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weekly_workload")
public class WeeklyWorkload {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weekly_workload_sequence")
    @SequenceGenerator(name = "weekly_workload_sequence", sequenceName = "weekly_workload_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private Integer contents_no_pr_daniela;

    private Integer contents_pr_daniela;

    private Integer campaign_preparation_daniela;

    private Integer campaign_active_daniela;

    private Integer profiles_no_pr_daniela;

    private Integer profiles_pr_daniela;

    private Integer contents_no_pr_estefany;

    private Integer contents_pr_estefany;

    private Integer campaign_preparation_estefany;

    private Integer campaign_active_estefany;

    private Integer profiles_no_pr_estefany;

    private Integer profiles_pr_estefany;

    private Integer contents_no_pr_luisa;

    private Integer contents_pr_luisa;

    private Integer campaign_preparation_luisa;

    private Integer campaign_active_luisa;

    private Integer profiles_no_pr_luisa;

    private Integer profiles_pr_luisa;


}
