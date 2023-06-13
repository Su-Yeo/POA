package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.WishlistEntity;
import com.sesacthon.poa.dto.WishlistDto;
import com.sesacthon.poa.dto.mapper.WishlistMapper;
import com.sesacthon.poa.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishlistService {
    private final WishlistRepository wishlistRepository; // JPA
    private final WishlistMapper wishlistMapper; // DTO로 변환

    public WishlistDto saveWishlist(WishlistDto wishlistDto) {
        WishlistEntity wishlistEntity = wishlistMapper.toEntity(wishlistDto);
        return wishlistMapper.toDto(wishlistRepository.save(wishlistEntity));
    }

    /**
     * 좋아요 취소
     * @param artwork_id
     * @param user_id
     */
    public void deleteWishlist(Integer artwork_id, Integer user_id) {
        wishlistRepository.deleteByArtWorkIdAndUserId(artwork_id, user_id);
    }

    /**
     * 작품 좋아요 여부 확인
     * @param artwork_id
     * @param user_id
     */
    public boolean findArtworkLike(Integer artwork_id, Integer user_id) {
        int i = wishlistRepository.findByArtWorkIdAndUserId(artwork_id, user_id);
        return i==0 ? false : true;
    }
}
