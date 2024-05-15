package com.example.RealUpCotizador.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitiesRepository extends JpaRepository<Cities, Long> {

//    @Query(value = "SELECT city_ascii FROM archivo WHERE country = 'Colombia'", nativeQuery = true)
//    List<Cities> findByColombia(String pais);

    List<Cities> findCitiesByCountry(String pais);
}
