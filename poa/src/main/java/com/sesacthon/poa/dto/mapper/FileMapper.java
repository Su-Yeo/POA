package com.sesacthon.poa.dto.mapper;

import com.sesacthon.poa.domain.FileEntity;
import com.sesacthon.poa.dto.FileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper extends StructMapper<FileDto, FileEntity> {
}
