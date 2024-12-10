package com.example.RealUpCotizador.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    @Query(value = """
        SELECT i.*
        FROM realupdb.influencer i,
        JSON_TABLE(
            i.followers,
            '$[*]' COLUMNS (
                media VARCHAR(50) PATH '$.media',
                value DOUBLE PATH '$.value'
            )
        ) AS f
        WHERE f.media = 'Instagram'
        ORDER BY f.value DESC
        LIMIT 45;
    """, nativeQuery = true)
    List<Influencer> findTop45ByInstagramFollowers();
}
