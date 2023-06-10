package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuyInfoDto { // 구매정보 Dto

    private Integer BuyInfo_id;

    private Integer artwork_id;

    private Integer user_id;

    private String buy_address;

    private Integer pay_price;

//    private String pay_date;

    private int visible; // // true,1: 공개허용 / false,0: 비허용

    private Integer buy_state; // // true,1: 결재완료, 판매완료 / false,0: 결재취소, 판매중

}
