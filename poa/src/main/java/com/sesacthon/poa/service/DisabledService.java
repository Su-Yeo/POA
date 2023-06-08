package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.DisabledEntity;
import com.sesacthon.poa.dto.DisabledDto;
import com.sesacthon.poa.dto.mapper.DisabledMapper;
import com.sesacthon.poa.repository.DisabledRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DisabledService {
    private final DisabledRepository disabledRepository; // JPA
    private final DisabledMapper disabledMapper; // DTO로 변환

    /**
     * 장애 정보 저장
     * @param disabledDto
     * @return DisabledDto
     */
    public DisabledDto saveDisabled(DisabledDto disabledDto) {
        DisabledEntity disabledEntity = disabledMapper.toEntity(disabledDto);
        return disabledMapper.toDto(disabledRepository.save(disabledEntity));
    }

    /**
     * 장애 정보 조회
     * @param disabled_id
     * @return DisabledDto
     */
    public DisabledDto findDisabled(Integer disabled_id) {
        return disabledMapper.toDto(disabledRepository.findById(disabled_id).orElse(null));
    }
}
