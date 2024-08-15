package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.vo.CampaignState;
import com.example.RealUpCotizador.vo.CampaignType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_sequence")
    @SequenceGenerator(name = "campaign_sequence", sequenceName = "campaign_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date initial_date;

    @Temporal(TemporalType.DATE)
    private Date final_date;

    private String name_op;

    private Integer task_completed;

    private Integer number_contents;

    private Integer number_creators;

    private Integer number_contents_done;

    private CampaignState campaign_state;

    private Double budget;

    private CampaignType campaign_type;

    private String country;

    private Boolean pr;
    
}
