package com.sesacthon.poa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatorDto { // 작가 정보 Dto

    private Integer creator_id;

    private String introduce;

    private String story;

    private Integer disabled_id;

}
