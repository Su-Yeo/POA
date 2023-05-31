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
@Table(name = "OnMarket")
public class OnMarketEntity extends BaseTimeEntity { // 판매작품 정보 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer market_id;
    @Column(nullable = false)
    private Integer creator_id;

    @Column(nullable = false)
    private Integer artwork_id;

    @Column(nullable = false)
    private Integer market_price;

    @Column(nullable = false)
    private Integer market_mount;

    @Column(nullable = false)
    private Integer total_price;

    @Column(nullable = false)
    private String deadline;

    @Column(nullable = false)
    private Integer market_state;

    @Builder
    public OnMarketEntity(Integer market_id, Integer creator_id, Integer artwork_id, Integer market_price, Integer market_mount,Integer total_price,String deadline, Integer market_state) {
        this.market_id = market_id;
        this.artwork_id = artwork_id;
        this.creator_id = creator_id;
        this.market_price = market_price;
        this.market_mount = market_mount;
        this.total_price = total_price;
        this.deadline = deadline;
        this.market_state = market_state;
    }
}
