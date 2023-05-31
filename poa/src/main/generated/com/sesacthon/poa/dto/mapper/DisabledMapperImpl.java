package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.UserEntity;
import com.sesacthon.poa.domain.UserEntity.UserEntityBuilder;
import com.sesacthon.poa.dto.DisabledDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T17:15:20+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (ojdkbuild)"
)
@Component
public class DisabledMapperImpl implements DisabledMapper {

    @Override
    public DisabledDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DisabledDto disabledDto = new DisabledDto();

        return disabledDto;
    }

    @Override
    public UserEntity toEntity(DisabledDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        return userEntity.build();
    }

    @Override
    public List<DisabledDto> toDtoList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisabledDto> list = new ArrayList<DisabledDto>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<DisabledDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( dtoList.size() );
        for ( DisabledDto disabledDto : dtoList ) {
            list.add( toEntity( disabledDto ) );
        }

        return list;
    }
}
