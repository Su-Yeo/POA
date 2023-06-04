package com.sesacthon.poa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisabledDto { // 장애 정보 Dto

    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    @Schema(description = "장애 정보 id")
    private Integer disabled_id;

    @Schema(description = "타입")
    @NotBlank(message = "타입 필수 입력 입니다.")
    private String disabled_type;

    @Schema(description = "설명")
    @NotBlank(message = "설명 필수 입력 입니다.")
    private String disabled_text;

}
