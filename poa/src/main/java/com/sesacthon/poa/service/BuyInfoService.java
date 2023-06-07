package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.BuyInfoEntity;
import com.sesacthon.poa.dto.BuyInfoDto;
import com.sesacthon.poa.dto.mapper.BuyInfoMapper;
import com.sesacthon.poa.repository.BuyInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuyInfoService {
    private final BuyInfoRepository buyInfoRepository; // JPA
    private final BuyInfoMapper buyInfoMapper; // DTO로 변환


    /**
     * 작가 정보 저장
     * @param buyInfoDto
     * @return BuyInfoDto
     */
    public BuyInfoDto saveBuyInfo(BuyInfoDto buyInfoDto) {
        BuyInfoEntity buyInfoEntity = buyInfoMapper.toEntity(buyInfoDto);
        return buyInfoMapper.toDto(buyInfoRepository.save(buyInfoEntity));
    }
}
