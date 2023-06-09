package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.CreatorEntity;
import com.sesacthon.poa.dto.CreatorDto;
import com.sesacthon.poa.dto.ReqCreatorDto;
import com.sesacthon.poa.dto.ResCreatorDto;
import com.sesacthon.poa.dto.mapper.CreatorMapper;
import com.sesacthon.poa.repository.CreatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResCreatorDto findCreator(Integer user_id){
        List<Object[]> objects = creatorRepository.findResCreator(user_id);
        if(objects.isEmpty()) return null;

        Object[] object = objects.get(0);

        ResCreatorDto resCreatorDto = new ResCreatorDto();
        // u.name, f.profile_url, c.story, d.disabled_type, d.disabled_text
        resCreatorDto.setName(object[0].toString());
        resCreatorDto.setProfile_url(object[1].toString());
        resCreatorDto.setStory(object[2].toString());
        resCreatorDto.setDisabled_type(object[3].toString());
        resCreatorDto.setDisabled_text(object[4].toString());

        return resCreatorDto;
    }
}
