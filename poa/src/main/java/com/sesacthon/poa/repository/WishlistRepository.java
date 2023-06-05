package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
    @Query("SELECT w.artwork_id FROM Wishlist w WHERE w.user_id = :user_id")
    List<Integer> findArtworkIdsByUserId(@Param("user_id") Integer user_id);


    
}
