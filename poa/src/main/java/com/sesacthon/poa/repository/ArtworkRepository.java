package com.sesacthon.poa.repository;

import com.sesacthon.poa.domain.ArtworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtworkRepository extends JpaRepository<ArtworkEntity, Integer> {

    /**
     * 예시 입니다!!
     * 기본 JPA 사용시 밑에처럼 작성 안해도 됩니다! (ex. findById(), findAll(), save(), ...)
     * <p>
     * // JPA 문법으로 사용
     * boolean findByEmailOrderByEmailAsc(String email);
     * <p>
     * // 쿼리 사용
     *
     * @Transactional(value = "transactionManager")
     * @Modifying
     * @Query(value = "UPDATE User SET update_time = NOW(), email = :email  WHERE user_id = :user_id", nativeQuery = true)
     * void endDispatch(@Param("email") String email, @Param("user_id") Integer user_id);
     */

    @Query(value = "SELECT a.* " +
            "FROM artwork a " +
            "JOIN wish_list w ON a.artwork_id = w.artwork_id " +
            "WHERE w.user_id = :user_id AND visible = TRUE",
            nativeQuery = true)
    List<ArtworkEntity> getArtworkByUserId(@Param("user_id") Integer user_id);

//        List<ArtworkEntity> findAll(Sort sort);
    @Query(value = "SELECT a.* " +
            "FROM artwork a " +
            "WHERE visible = TRUE"+
            "ORDER BY a.artwork_id DESC",
            nativeQuery = true)
    List<ArtworkEntity> findAllByOrderByArtworkIdDesc();
    @Query(value = "SELECT a.* " +
            "FROM artwork a " +
            "WHERE artwork_state = TRUE AND visible = TRUE "+
            "ORDER BY a.artwork_id DESC",
            nativeQuery = true)
    List<ArtworkEntity> findAllByArtworkStateOrderByArtworkIdDesc();


    @Query(value = "SELECT a.* " +
            "FROM artwork a " +
            "WHERE a.user_id = :creator_id AND visible = TRUE ORDER BY artwork_id DESC ",
            nativeQuery = true)
    List<ArtworkEntity> findAllByCreatorId(@Param("creator_id") Integer creator_id);

//    /**
//     * 작품 visible 업데이트
//     * @param artwork_id
//     * @param visible
//     * @return int
//     */
//    @Transactional(value = "transactionManager")
//    @Modifying
//    @Query(value = "UPDATE `artwork` SET visible = :visible WHERE artwork_id = :artwork_id", nativeQuery = true)
//    int updateArtworkVisible(@Param("artwork_id") Integer artwork_id, @Param("visible") int visible);
   /**
     * 작품 visible 업데이트
     * @param artwork_id
     * @param visible
     * @param artwork_state
     * @return int
     */
    @Transactional(value = "transactionManager")
    @Modifying
    @Query(value = "UPDATE `artwork` SET visible = :visible, artwork_state = :artwork_state WHERE artwork_id = :artwork_id", nativeQuery = true)
    int updateArtworkVisibleArtworkState(@Param("artwork_id") Integer artwork_id, @Param("visible") int visible, @Param("artwork_state") Integer artwork_state);




}
