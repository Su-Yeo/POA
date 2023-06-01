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
@Table(name = "Disabled")
public class DisabledEntity { // 장애 정보 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer disabled_id;

    @Column(nullable = false)
    private String disabled_type;

    @Column(nullable = false)
    private String disabled_text;

    @Builder
    public DisabledEntity(Integer disabled_id, String disabled_type, String disabled_text) {
        this.disabled_id = disabled_id;
        this.disabled_type = disabled_type;
        this.disabled_text = disabled_text;
    }
}
