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

    /**
     * 한번에 가져오는 거 안되어서 다른 걸로 바꿈!
     * 프로필 경로 + 사용자 정보 가져오기
     * @param user_id 유저 id
     * @return UserEntity
     */
//    @Query(value = "SELECT new com.sesacthon.poa.dto.UserDto (u.user_id, u.email, u.pw, u.name, u.phone, u.nick, f.file_url as profile_url, f.file_id as profile, u.address, u.creator_id) " +
//            "FROM `user` u JOIN file f  ON u.profile = f.file_id " +
//            "WHERE u.user_id = :user_id ")
//    UserDto findByUser(@Param("user_id") Integer user_id);

    /**
     * 작가 id 업데이트
     * @param user_id
     * @param creator_id
     * @return int
     */
    @Transactional(value = "transactionManager")
    @Modifying
    @Query(value = "UPDATE `user` SET creator_id = :creator_id WHERE user_id = :user_id", nativeQuery = true)
    int updateUserCreatorId(@Param("user_id") Integer user_id, @Param("creator_id") Integer creator_id);

}
