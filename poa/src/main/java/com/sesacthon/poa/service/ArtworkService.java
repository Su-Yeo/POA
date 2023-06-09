package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.ArtworkEntity;
import com.sesacthon.poa.dto.ArtworkDto;
import com.sesacthon.poa.dto.mapper.ArtworkMapper;
import com.sesacthon.poa.repository.ArtworkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
     * @param artworkDto
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
//        List<ArtworkEntity> lastArtworks = artworkRepository.findAll(Sort.by(Sort.Direction.DESC, "artwork_id"));
//        List<ArtworkEntity> lastArtworks = artworkRepository.findAll();
        List<ArtworkEntity> lastArtworks = artworkRepository.findAllByOrderByArtworkIdDesc();
        return artworkMapper.toDtoList(lastArtworks);
    }

  /**
     * 구매가능한 최신의 아트 정보리스트 전달
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> findAllBuyingDesc(){
//        List<ArtworkEntity> lastArtworks = artworkRepository.findAll(Sort.by(Sort.Direction.DESC, "artwork_id"));
//        List<ArtworkEntity> lastArtworks = artworkRepository.findAll();
        List<ArtworkEntity> buyingArtworks = artworkRepository.findAllByArtworkStateOrderByArtworkIdDesc();
        return artworkMapper.toDtoList(buyingArtworks);
    }


    /**
     * 1명의 유저가 좋아요한 최신순 리스트
     * @param user_id
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> findWishlistByUserId(Integer user_id){
        List<ArtworkEntity> likedArtworks = artworkRepository.findWishlistByUserId(user_id);
        return artworkMapper.toDtoList(likedArtworks);
    }

//    /**
//     * 좋아요 많은 아트의 정보리스트 전달
//     * @return List<ArtworkDto>
//     */
//    public List<ArtworkDto> findAllOrderByWishlist(){
//        List<ArtworkEntity> manyArtworks = artworkRepository.findAll(Sort.by(Sort.Direction.DESC, "artwork_id"));
//        return artworkMapper.toDtoList(manyArtworks);
//    }


    /**
     * 작가의 작품 리스트
     * @param creator_id
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> findAllByCreatorId(Integer creator_id){
        List<ArtworkEntity> artworkEntityList = artworkRepository.findAllByCreatorId(creator_id);
        return artworkMapper.toDtoList(artworkEntityList);
    }
//artwork의 visible 하나만 업데이트 할 때
//    public boolean updateArtworkVisible(Integer artwork_id, int visible ){
//        int i = artworkRepository.updateArtworkVisible(artwork_id, visible);
//        return i==0 ? false : true;
//    }
//    artwork의 visible과 artwork_state를 동시에 업데이트 할 때
    public boolean updateArtworkVisibleArtworkState(Integer artwork_id, int visible,Integer artwork_state ){
        int i = artworkRepository.updateArtworkVisibleArtworkState(artwork_id, visible, artwork_state);
        return i==0 ? false : true;
    }

    /**
     * 좋아요 많은 순 작품 리스트
     * @return List<ArtworkDto>
     */
    public List<ArtworkDto> findArtworkByWishList() {
        List<ArtworkEntity> artworkEntityList = artworkRepository.findArtworkByWishList();
        return artworkMapper.toDtoList(artworkEntityList);
    }
}
