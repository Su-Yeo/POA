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

    public DisabledService(DisabledRepository disabledRepository, DisabledMapper disabledMapper) {
        this.disabledRepository = disabledRepository;
        this.disabledMapper = disabledMapper;
    }
    /**
     * 장애 정보 저장
     * @param disabledDto
     * @return DisabledDto
     */
    public DisabledDto saveDisabled(DisabledDto disabledDto) {
        DisabledEntity disabledEntity = disabledMapper.toEntity(disabledDto);
        return disabledMapper.toDto(disabledRepository.save(disabledEntity));
    }
}
