package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Integer> {
}
