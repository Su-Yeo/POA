package com.sesacthon.poa.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "WishList")
public class WishlistEntity extends BaseTimeEntity { // 좋아요 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer wishlist_id;
    @Column(nullable = false)
    private Integer user_id;
    @Column(nullable = false)
    private Integer artwork_id;

//    @Column(nullable = false)
//    private Integer creator_id;

    @Builder
    public WishlistEntity(Integer wishlist_id, Integer user_id, Integer artwork_id) {
        this.wishlist_id = wishlist_id;
        this.user_id = user_id;
        this.artwork_id = artwork_id;
    }
}
