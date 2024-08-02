package com.example.RealUpCotizador.dto;

import com.example.RealUpCotizador.vo.CampaignState;
import com.example.RealUpCotizador.vo.CampaignType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CampaignDTO {

    private String name;

    private Date initial_date;

    private Date final_date;

    private String name_op;

    private Integer task_completed;

    private Integer number_contents;

    private Integer number_creators;

    private Double budget;

    private CampaignType campaign_type;

    private String country;

    private Boolean pr;

}
