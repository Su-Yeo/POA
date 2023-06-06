package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.WishlistEntity;
import com.sesacthon.poa.dto.WishlistDto;
import com.sesacthon.poa.dto.mapper.WishlistMapper;
import com.sesacthon.poa.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
