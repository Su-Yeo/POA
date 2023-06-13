package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.WishlistEntity;
import com.sesacthon.poa.dto.WishlistDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Integer> {
    @Transactional(value = "transactionManager")
    @Query(value="DELETE FROM wish_list WHERE user_id = :user_id AND artwork_id = :artwork_id",nativeQuery = true)
    void deleteByArtWorkIdAndUserId(@Param("artwork_id")Integer artwork_id, @Param("user_id")Integer user_id);

    @Query(value="SELECT EXISTS (SELECT 1 FROM wish_list WHERE user_id = :user_id AND artwork_id = :artwork_id)",nativeQuery = true)
    int findByArtWorkIdAndUserId(@Param("artwork_id")Integer artwork_id, @Param("user_id")Integer user_id);
}
