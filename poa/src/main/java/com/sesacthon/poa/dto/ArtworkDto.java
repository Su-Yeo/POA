package com.sesacthon.poa.dto;


import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtworkDto { // 작품 Dto

    private Integer artwork_id;

    private Integer user_id;

    private Integer category_id;

    private Integer file_id;

    private String file_url;

    private String title;

    private String content;

    private Integer artwork_price;

    private String artwork_size;

    private Integer artwork_state; // 0:판매완료 / 1:판매중

    private int visible; // true: 공개허용 / false: 비허용

    private Integer buy_state; // 1: 결재완료 / 0: 결재취소

    private Integer like_cnt; // 좋아요 갯수
}
