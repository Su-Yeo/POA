package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.ArtworkEntity;
import com.sesacthon.poa.dto.ArtworkDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtworkMapper extends StructMapper<ArtworkDto, ArtworkEntity> {
}
