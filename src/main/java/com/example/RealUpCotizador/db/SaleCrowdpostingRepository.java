package com.example.RealUpCotizador.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleCrowdpostingRepository extends JpaRepository <SaleCrowdposting, Long> {

    @Query(value = "SELECT next_val FROM sale_crowdposting_sequence", nativeQuery = true)
    Long getNextValSale();

    @Query(value = "SELECT next_val FROM sale_crowdposting_sequence ORDER BY next_val DESC LIMIT 1", nativeQuery = true)
    Long getLastValSale();

}
