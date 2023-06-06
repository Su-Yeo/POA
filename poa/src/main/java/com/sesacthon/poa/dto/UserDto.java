package com.sesacthon.poa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    @Schema(description = "일반/작가 유저 id")
    private Integer user_id; // 일반, 작가 id

    @Schema(description = "이메일", example = "poa@naver.com")
    @NotBlank(message = "이메일 필수 입력 입니다.")
    private String email;

    @Schema(description = "비밀번호", example = "1234")
    @NotBlank(message = "비밀번호 필수 입력 입니다.")
    private String pw;

    @Schema(description = "비밀번호", example = "1234")
    @NotBlank(message = "비밀번호 필수 입력 입니다.")
    private String name;

    @Schema(description = "전화번호", example = "010-1234-1234")
    @NotBlank(message = "전화번호 필수 입력 입니다.")
    private String phone;

    @Schema(description = "닉네임", example = "1234")
    @NotBlank(message = "닉네임 필수 입력 입니다.")
    private String nick;

    @Schema(description = "프로필", example = "파일 url", nullable = true)
    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    private String profile_url;

    @Schema(hidden = true)
    private Integer profile;

    @Schema(description = "주소", example = "1234")
    @NotBlank(message = "주소 필수 입력 입니다.")
    private String address;

    @Schema(description = "작가정보 id", nullable = true, example = "null")
    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    private Integer creator_id; // null: 일반 / creator_id: 작가
}
