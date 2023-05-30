package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.dto.CreatorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatorMapper extends StructMapper<CreatorDto, CreatorEntity> {
}
