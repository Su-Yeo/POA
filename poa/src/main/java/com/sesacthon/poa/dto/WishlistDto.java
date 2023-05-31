package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WishlistDto { // 좋아요 Dto

    private Integer wishlist_id;

    private Integer artwork_id;

    private Integer user_id;



}
