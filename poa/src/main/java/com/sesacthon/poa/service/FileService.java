package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.FileEntity;
import com.sesacthon.poa.dto.FileDto;
import com.sesacthon.poa.dto.mapper.FileMapper;
import com.sesacthon.poa.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
    private final FileRepository fileRepository; // JPA
    private final FileMapper fileMapper; // DTO로 변환

    public FileService(FileRepository fileRepository, FileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }
    /**
     * 파일 저장
     * @param fileDto
     * @return FileDto
     */
    public FileDto saveFile(FileDto fileDto) {
        FileEntity fileEntity = fileMapper.toEntity(fileDto);
        return fileMapper.toDto(fileRepository.save(fileEntity));
    }
}
