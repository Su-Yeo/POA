package com.sesacthon.poa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Integer user_id; // 작가 id

    private String email;

    private String pw;

    private String name;

    private String phone;

    private String nick;

    private String profile;

    private String address;

    private Integer creator_id; // null: 일반 / creator_id: 작가
}
