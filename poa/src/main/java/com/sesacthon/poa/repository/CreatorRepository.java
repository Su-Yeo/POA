package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CreatorRepository extends JpaRepository<CreatorEntity, Integer> {
    @Query(value = "SELECT u.name, f.file_url as profile_url, c.story, d.disabled_type, d.disabled_text " +
            "FROM `user` u " +
            "JOIN file f ON f.file_id = u.profile " +
            "JOIN creator c ON c.creator_id = u.creator_id " +
            "JOIN disabled d ON d.disabled_id = c.disabled_id " +
            "WHERE u.user_id = :user_id", nativeQuery = true)
    List<Object[]> findResCreator(@Param("user_id") Integer user_id);
}
