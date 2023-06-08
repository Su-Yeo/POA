package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.dto.CreatorDto;
import com.sesacthon.poa.dto.ReqCreatorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatorMapper extends StructMapper<CreatorDto, CreatorEntity> {
//    @Mapping(target = "user_id", ignore = true)
    CreatorEntity reqDtoToEntity(ReqCreatorDto reqCreatorDto);
}
