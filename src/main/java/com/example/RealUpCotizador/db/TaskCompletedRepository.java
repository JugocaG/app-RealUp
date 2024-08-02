package com.example.RealUpCotizador.db;

import com.example.RealUpCotizador.dto.TaskCompletedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCompletedRepository extends JpaRepository <TaskCompleted, Long> {

    TaskCompleted findByIdCampaign(Long idCampaign);


}
