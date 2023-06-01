package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * 예시 입니다!!
     * 기본 JPA 사용시 밑에처럼 작성 안해도 됩니다! (ex. findById(), findAll(), save(), ...)

    // JPA 문법으로 사용
    boolean findByEmailOrderByEmailAsc(String email);

    // 쿼리 사용
    @Transactional(value = "transactionManager")
    @Modifying
    @Query(value = "UPDATE User SET update_time = NOW(), email = :email  WHERE user_id = :user_id", nativeQuery = true)
    void endDispatch(@Param("email") String email, @Param("user_id") Integer user_id);

     */
}
