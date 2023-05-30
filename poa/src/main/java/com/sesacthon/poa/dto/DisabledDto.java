package com.sesacthon.poa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisabledDto { // 장애 정보 Dto

    private Integer disabled_id;

    private String disabled_type;

    private String disabled_text;

}
