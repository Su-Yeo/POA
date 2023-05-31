package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OnMarketDto { // 판매작품정보 Dto

    private Integer market_id;

    private Integer artwork_id;

    private Integer creator_id;

    private Integer market_price;

    private Integer total_price;

    private String deadline;

    private Integer market_state;

}
