package com.sesacthon.poa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResCreatorDto { // response 작가 정보 Dto

    private UserDto userDto;

    private CreatorDto creatorDto;

    private DisabledDto disabledDto;

    private List<ArtworkDto> artworkDtoList;
}
