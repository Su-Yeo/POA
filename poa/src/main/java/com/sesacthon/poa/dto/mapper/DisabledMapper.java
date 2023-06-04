package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.DisabledEntity;
import com.sesacthon.poa.dto.DisabledDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DisabledMapper extends StructMapper<DisabledDto, DisabledEntity> {
}
