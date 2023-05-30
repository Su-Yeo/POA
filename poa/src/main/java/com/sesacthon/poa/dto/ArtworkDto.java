package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtworkDto { // 작품 Dto

    private Integer artwork_id;

    private Integer user_id;

    private Integer category_id;

    private Integer file_id;

    private String title;

    private String content;

}
