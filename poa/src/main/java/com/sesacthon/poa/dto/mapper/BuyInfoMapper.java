package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.BuyInfoEntity;
import com.sesacthon.poa.dto.BuyInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyInfoMapper extends StructMapper<BuyInfoDto, BuyInfoEntity> {
}
