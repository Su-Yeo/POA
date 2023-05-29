package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.UserEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntitiy, Integer> {
}
