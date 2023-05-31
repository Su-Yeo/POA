package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.UserEntity;
import com.sesacthon.poa.domain.UserEntity.UserEntityBuilder;
import com.sesacthon.poa.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T17:15:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (ojdkbuild)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUser_id( entity.getUser_id() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPw( entity.getPw() );
        userDto.setName( entity.getName() );
        userDto.setPhone( entity.getPhone() );
        userDto.setNick( entity.getNick() );
        userDto.setProfile( entity.getProfile() );
        userDto.setAddress( entity.getAddress() );
        userDto.setCreator_id( entity.getCreator_id() );

        return userDto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.user_id( dto.getUser_id() );
        userEntity.email( dto.getEmail() );
        userEntity.pw( dto.getPw() );
        userEntity.name( dto.getName() );
        userEntity.phone( dto.getPhone() );
        userEntity.nick( dto.getNick() );
        userEntity.profile( dto.getProfile() );
        userEntity.address( dto.getAddress() );
        userEntity.creator_id( dto.getCreator_id() );

        return userEntity.build();
    }

    @Override
    public List<UserDto> toDtoList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
