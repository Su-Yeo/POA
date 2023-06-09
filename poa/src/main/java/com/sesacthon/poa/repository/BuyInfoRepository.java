package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.BuyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BuyInfoRepository extends JpaRepository<BuyInfoEntity, Integer> {
    /**
     * 작품 visible 업데이트
     * @param buyInfo_id
     * @param buy_state
     * @param delete_time
     * @return int
     */
    @Transactional(value = "transactionManager")
    @Modifying
    @Query(value = " update buy_info b " +
            "SET b.buy_state = :buy_state, b.delete_time = :delete_time " +
            "WHERE B.buy_info_id = :buyInfo_id", nativeQuery = true)
    int updateBuyInfoByBuyStateDeleteTime(@Param("buyInfo_id") Integer buyInfo_id, @Param("buy_state") Integer buy_state, @Param("delete_time") LocalDateTime delete_time);



}
