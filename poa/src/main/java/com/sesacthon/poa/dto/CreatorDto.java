package com.sesacthon.poa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatorDto { // 작가 정보 Dto

    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    @Schema(description = "작가 정보 id")
    private Integer creator_id;

    @Schema(description = "소개")
    @NotBlank(message = "소개 필수 입력 입니다.")
    private String introduce;

    @Schema(description = "작가 스토리")
    @NotBlank(message = "작가 스토리 필수 입력 입니다.")
    private String story;

    @Schema(description = "장애 정보 id", nullable = true, example = "null")
    private Integer disabled_id;

}
