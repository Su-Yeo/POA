package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.ArtworkEntity;
import com.sesacthon.poa.domain.ArtworkEntity.ArtworkEntityBuilder;
import com.sesacthon.poa.dto.ArtworkDto;
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
public class ArtworkMapperImpl implements ArtworkMapper {

    @Override
    public ArtworkDto toDto(ArtworkEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ArtworkDto artworkDto = new ArtworkDto();

        artworkDto.setArtwork_id( entity.getArtwork_id() );
        artworkDto.setUser_id( entity.getUser_id() );
        artworkDto.setCategory_id( entity.getCategory_id() );
        artworkDto.setFile_id( entity.getFile_id() );
        artworkDto.setTitle( entity.getTitle() );
        artworkDto.setContent( entity.getContent() );

        return artworkDto;
    }

    @Override
    public ArtworkEntity toEntity(ArtworkDto dto) {
        if ( dto == null ) {
            return null;
        }

        ArtworkEntityBuilder artworkEntity = ArtworkEntity.builder();

        artworkEntity.artwork_id( dto.getArtwork_id() );
        artworkEntity.user_id( dto.getUser_id() );
        artworkEntity.category_id( dto.getCategory_id() );
        artworkEntity.file_id( dto.getFile_id() );
        artworkEntity.title( dto.getTitle() );
        artworkEntity.content( dto.getContent() );

        return artworkEntity.build();
    }

    @Override
    public List<ArtworkDto> toDtoList(List<ArtworkEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ArtworkDto> list = new ArrayList<ArtworkDto>( entityList.size() );
        for ( ArtworkEntity artworkEntity : entityList ) {
            list.add( toDto( artworkEntity ) );
        }

        return list;
    }

    @Override
    public List<ArtworkEntity> toEntityList(List<ArtworkDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ArtworkEntity> list = new ArrayList<ArtworkEntity>( dtoList.size() );
        for ( ArtworkDto artworkDto : dtoList ) {
            list.add( toEntity( artworkDto ) );
        }

        return list;
    }
}
