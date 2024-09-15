package com.example.RealUpCotizador.db;
import com.example.RealUpCotizador.vo.CampaignState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository <Campaign, Long> {
    @Query("SELECT c FROM Campaign c WHERE c.campaign_state = :campaignState")
    List<Campaign> findCampaignsByState(@Param("campaignState") CampaignState campaignState);

    @Query(value = "SELECT next_val FROM campaign_sequence", nativeQuery = true)
    Long getLastValueOfCampaignSequence();

    @Query("SELECT c.name FROM Campaign c WHERE c.name_op = :nameOp")
    List<String> findCampaignNamesByNameOp(String nameOp);


}
