package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.dto.CreatorDto;
import com.sesacthon.poa.dto.ReqCreatorDto;
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

    /**
     * 작가 정보 저장
     * @param reqCreatorDto
     * @return CreatorDto
     */
    public CreatorDto saveCreator(ReqCreatorDto reqCreatorDto) {
        CreatorEntity creatorEntity = creatorMapper.reqDtoToEntity(reqCreatorDto);
        return creatorMapper.toDto(creatorRepository.save(creatorEntity));
    }

    public CreatorDto findCreator(Integer creator_id){
        return creatorMapper.toDto(creatorRepository.findById(creator_id).orElse(null));
    }
}
