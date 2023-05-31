package com.sesacthon.poa.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDto { // 저장된파일정보 Dto

    private Integer file_id;

    private String file_name;

    private String file_url;

    private String file_path;



}
