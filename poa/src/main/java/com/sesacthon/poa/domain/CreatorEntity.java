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
@Table(name = "Creator")
public class CreatorEntity { // 작가 정보 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer creator_id;

//    @Column(nullable = false)
//    private String introduce;

    @Column(nullable = false)
    private String story;

    private Integer disabled_id;

    @Builder
    public CreatorEntity(Integer creator_id, String story, Integer disabled_id) {
        this.creator_id = creator_id;
        this.story = story;
        this.disabled_id = disabled_id;
    }
}
