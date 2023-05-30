package com.sesacthon.poa.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "User")
public class UserEntity extends BaseTimeEntity { // 유저 테이블
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer user_id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String profile;

    private String address;

    private Integer creator_id;

    @Builder
    public UserEntity(Integer user_id, String email, String pw, String name, String phone, String nick, String profile, String address, Integer creator_id) {
        this.user_id = user_id;
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.nick = nick;
        this.profile = profile;
        this.address = address;
        this.creator_id = creator_id;
    }
}
