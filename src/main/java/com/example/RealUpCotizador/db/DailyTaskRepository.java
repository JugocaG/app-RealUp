package com.example.RealUpCotizador.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {

    List<DailyTask> findByOp(String nameOp);
}
