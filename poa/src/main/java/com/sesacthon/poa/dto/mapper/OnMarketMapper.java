package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.OnMarketEntity;
import com.sesacthon.poa.dto.OnMarketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OnMarketMapper extends StructMapper<OnMarketDto, OnMarketEntity> {
}
