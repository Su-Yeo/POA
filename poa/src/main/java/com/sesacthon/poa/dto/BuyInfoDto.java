package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuyInfoDto { // 구매정보 Dto

    private Integer BuyInfo_id;

    private Integer market_id;

    private Integer user_id;

    private String buy_address;

    private Integer pay_price;

    private String pay_date;

}
