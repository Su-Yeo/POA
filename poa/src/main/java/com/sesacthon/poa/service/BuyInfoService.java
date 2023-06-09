package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.BuyInfoEntity;
import com.sesacthon.poa.dto.BuyInfoDto;
import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.dto.mapper.BuyInfoMapper;
import com.sesacthon.poa.repository.BuyInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuyInfoService {
    private final BuyInfoRepository buyInfoRepository; // JPA
    private final BuyInfoMapper buyInfoMapper; // DTO로 변환


    /**
     * 구매 정보 저장
     * @param buyInfoDto
     * @return BuyInfoDto
     */
    public BuyInfoDto saveBuyInfo(BuyInfoDto buyInfoDto) {
        BuyInfoEntity buyInfoEntity = buyInfoRepository.save(buyInfoMapper.toEntity(buyInfoDto));
        return buyInfoMapper.toDto(buyInfoEntity);
    }

    /**
     * buyInfo_id로 구매 정보 조회
     * @param buyInfo_id
     * @return BuyInfoDto
     */
    public BuyInfoDto findBuyInfoById(Integer buyInfo_id){
        return buyInfoMapper.toDto(buyInfoRepository.findById(buyInfo_id).orElse(null));
    }

    /**
     * 구매 취소 정보 저장
     * @param buyInfo_id
     * @return BuyInfoDto
     */
    public boolean updateBuyInfoByBuyStateDeleteTime(Integer buyInfo_id, Integer buy_state, LocalDateTime delete_time) {
        int i = buyInfoRepository.updateBuyInfoByBuyStateDeleteTime(buyInfo_id,buy_state,delete_time);
//        if (i > 0) {
//            BuyInfoDto buyInfoDto = new BuyInfoDto();
//            buyInfoDto.setBuyInfo_id(buyInfo_id);
//            buyInfoDto.setBuy_state(buy_state);
//            buyInfoDto.setDelete_time(delete_time);
//            return buyInfoDto;
//        }
//        return null;
        return i==0 ? false : true;
    }

}
