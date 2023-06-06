package com.sesacthon.poa.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDto { // 저장된 파일정보 Dto

    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    @Schema(description = "파일 id")
    private Integer file_id;

    @Schema(description = "파일명")
    @NotBlank(message = "파일명 필수 입력 입니다.")
    private String file_name;

    @Schema(description = "파일 URL")
    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    private String file_url;

    @Schema(description = "파일경로")
    @JsonIgnoreProperties(ignoreUnknown = true) // 값 무시
    private String file_path;

}
