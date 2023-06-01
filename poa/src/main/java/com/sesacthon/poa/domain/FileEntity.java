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
@Table(name = "File")
public class FileEntity extends BaseTimeEntity { // 저장된 파일정보 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer file_id;

    @Column(nullable = false)
    private String file_name;

    @Column(nullable = false)
    private String file_url;

    @Column(nullable = false)
    private String file_path;

    @Builder
    public FileEntity(Integer file_id, String file_name, String file_url, String file_path) {
        this.file_id = file_id;
        this.file_name = file_name;
        this.file_url = file_url;
        this.file_path = file_path;

    }
}
