package com.sesacthon.poa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResCreatorDto { // response 작가 정보 Dto

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "프로필", example = "파일 url", nullable = true)
    private String profile_url;

    @Schema(description = "작가 스토리")
    private String story;

    @Schema(description = "장애 타입")
    private String disabled_type;

    @Schema(description = "장애 설명")
    private String disabled_text;

    @Schema(description = "작품 정보 리스트")
    private List<ArtworkDto> artworkDtoList;
}
