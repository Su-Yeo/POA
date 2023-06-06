package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.ArtworkEntity;
import com.sesacthon.poa.domain.UserEntity;
import com.sesacthon.poa.dto.ArtworkDto;
import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.dto.mapper.ArtworkMapper;
import com.sesacthon.poa.repository.ArtworkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtworkService {
    private final ArtworkRepository artworkRepository; // JPA
    private final ArtworkMapper artworkMapper; // DTO로 변환

    /**
     * 1개의 아트의 정보 저장
     * @param ArtworkDto
     * @return ArtworkDto
     */
    public ArtworkDto saveArtwork(ArtworkDto artworkDto){
        ArtworkEntity artworkEntity = artworkRepository.save(artworkMapper.toEntity(artworkDto));
        return artworkMapper.toDto(artworkEntity);
    }
    /**
     * 1개의 아트의 정보 전달
     * @param artwork_id
     * @return ArtworkDto
     */
    public ArtworkDto findArtwork(Integer artwork_id){
        return artworkMapper.toDto(artworkRepository.findById(artwork_id).orElse(null));
    }
    /**
     * 최신의 아트의 정보리스트 전달
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> findAllDesc(){
        List<ArtworkEntity> lastArtworks = artworkRepository.findAll(Sort.by(Sort.Direction.DESC, "artwork_id"));
        return artworkMapper.toDtoList(lastArtworks);
    }


    /**
     * 1명의 유저가 좋아요한 리스트
     * @param user_id
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> getArtworkByUserId(Integer user_id){
        List<ArtworkEntity> likedArtworks = artworkRepository.getArtworkByUserId(user_id);
        return artworkMapper.toDtoList(likedArtworks);
    }

}
