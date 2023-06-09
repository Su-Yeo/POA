package com.sesacthon.poa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResCreatorDto { // response 작가 정보 Dto

    private String name;

    private String profile_url;

    private String story;

    private String disabled_type;

    private String disabled_text;

    private List<ArtworkDto> artworkDtoList;
}
