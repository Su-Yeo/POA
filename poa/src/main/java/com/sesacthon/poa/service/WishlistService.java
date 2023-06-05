package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.WishlistEntity;
import com.sesacthon.poa.dto.WishlistDto;
import com.sesacthon.poa.dto.ArtworkDto;
import com.sesacthon.poa.dto.mapper.ArtworkMapper;
import com.sesacthon.poa.dto.mapper.WishlistMapper;
import com.sesacthon.poa.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistService {
    private final WishlistRepository wishlistRepository; // JPA
    private final WishlistMapper wishlistMapper; // DTO로 변환
    private final ArtworkMapper artworkMapper; // DTO로 변환

//    public WishlistService(WishlistRepository wishlistRepository,  WishlistMapper wishlistMapper, ArtworkMapper artworkMapper) {
//        this.wishlistRepository = wishlistRepository;
//        this.wishlistMapper = wishlistMapper;
//        this.artworkMapper = artworkMapper;
//    }

    /**
     * user_id로 유저 조회
//     * @param user_id
     * @return UserDto
     */
    public List<Integer> findArtworkByUserId(Integer user_id){

        return wishlistRepository.findArtworkIdsByUserId(user_id);
    }
}
