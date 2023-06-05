package com.sesacthon.poa.service;

import com.sesacthon.poa.dto.ArtworkDto;
import com.sesacthon.poa.dto.mapper.ArtworkMapper;
import com.sesacthon.poa.repository.ArtworkRepository;
import com.sesacthon.poa.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtworkService {
    private final ArtworkRepository artworkRepository; // JPA
    private final ArtworkMapper artworkMapper; // DTO로 변환
    private final WishlistRepository wishlistRepository;

//    public ArtworkService(ArtworkRepository artworkRepository, ArtworkMapper artworkMapper, WishlistRepository wishlistRepository) {
//        this.artworkRepository = artworkRepository;
//        this.artworkMapper = artworkMapper;
//        this.wishlistRepository = wishlistRepository;
//    }
    /**
     * user_id로 유저 조회
//     * @param user_id
     * @return UserDto
     */
    public ArtworkDto findArtwork(Integer artwork_id){
        return artworkMapper.toDto(artworkRepository.findById(artwork_id).orElse(null));
    }
    public List<ArtworkDto> getArtworkByUserId(Integer user_id){
        List<Integer> artworkIds = wishlistRepository.findArtworkIdsByUserId(user_id);
        List<ArtworkDto> likedArtworks = new ArrayList<>();
        for (Integer artworkId : artworkIds) {
            ArtworkDto artworkDto = findArtwork(artworkId);
            if (artworkDto != null) {
                likedArtworks.add(artworkDto);
            }
        }
        return likedArtworks;
    }
}
