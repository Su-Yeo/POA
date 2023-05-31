package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.domain.CreatorEntity.CreatorEntityBuilder;
import com.sesacthon.poa.dto.CreatorDto;
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
public class CreatorMapperImpl implements CreatorMapper {

    @Override
    public CreatorDto toDto(CreatorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CreatorDto creatorDto = new CreatorDto();

        creatorDto.setCreator_id( entity.getCreator_id() );
        creatorDto.setIntroduce( entity.getIntroduce() );
        creatorDto.setStory( entity.getStory() );
        creatorDto.setDisabled_id( entity.getDisabled_id() );

        return creatorDto;
    }

    @Override
    public CreatorEntity toEntity(CreatorDto dto) {
        if ( dto == null ) {
            return null;
        }

        CreatorEntityBuilder creatorEntity = CreatorEntity.builder();

        creatorEntity.creator_id( dto.getCreator_id() );
        creatorEntity.introduce( dto.getIntroduce() );
        creatorEntity.story( dto.getStory() );
        creatorEntity.disabled_id( dto.getDisabled_id() );

        return creatorEntity.build();
    }

    @Override
    public List<CreatorDto> toDtoList(List<CreatorEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CreatorDto> list = new ArrayList<CreatorDto>( entityList.size() );
        for ( CreatorEntity creatorEntity : entityList ) {
            list.add( toDto( creatorEntity ) );
        }

        return list;
    }

    @Override
    public List<CreatorEntity> toEntityList(List<CreatorDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CreatorEntity> list = new ArrayList<CreatorEntity>( dtoList.size() );
        for ( CreatorDto creatorDto : dtoList ) {
            list.add( toEntity( creatorDto ) );
        }

        return list;
    }
}
