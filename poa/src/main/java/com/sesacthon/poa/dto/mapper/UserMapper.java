package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.UserEntity;
import com.sesacthon.poa.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends StructMapper<UserDto, UserEntity> {
}
