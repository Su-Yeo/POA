package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.DisabledEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisabledRepository extends JpaRepository<DisabledEntity, Integer> {
}
