package com.sesacthon.poa.service;

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
}
