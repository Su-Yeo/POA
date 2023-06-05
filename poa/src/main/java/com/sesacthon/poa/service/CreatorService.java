package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.dto.CreatorDto;
import com.sesacthon.poa.dto.mapper.CreatorMapper;
import com.sesacthon.poa.repository.CreatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatorService {
    private final CreatorRepository creatorRepository; // JPA
    private final CreatorMapper creatorMapper; // DTO로 변환

//    public CreatorService(CreatorRepository creatorRepository, CreatorMapper creatorMapper) {
//        this.creatorRepository = creatorRepository;
//        this.creatorMapper = creatorMapper;
//    }
    /**
     * 작가 정보 저장
     * @param creatorDto
     * @return CreatorDto
     */
    public CreatorDto saveCreator(CreatorDto creatorDto) {
        CreatorEntity creatorEntity = creatorMapper.toEntity(creatorDto);
        return creatorMapper.toDto(creatorRepository.save(creatorEntity));
    }
}
