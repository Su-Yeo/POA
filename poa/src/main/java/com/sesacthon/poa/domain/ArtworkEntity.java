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
@Table(name = "Artwork")
public class ArtworkEntity extends BaseTimeEntity { // 작품 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer artwork_id;
    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false)
    private Integer category_id;

    @Column(nullable = false)
    private Integer file_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public ArtworkEntity(Integer artwork_id, Integer user_id, Integer category_id, Integer file_id, String title, String content) {
        this.artwork_id = artwork_id;
        this.user_id = user_id;
        this.category_id = category_id;
        this.file_id = file_id;
        this.title = title;
        this.content = content;
    }
}
