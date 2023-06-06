package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.ArtworkDto;
import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.dto.WishlistDto;
import com.sesacthon.poa.service.WishlistService;
import com.sesacthon.poa.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class PoaController2 {
    private final ArtworkService artworkService; //
    private final WishlistService wishlistService; //

    /**
     * 1개의 아트의 정보 전달
     * @param artwork_id
     * @return ArtworkDto
     */
    @Tag(name = "Artwork", description = "작품")
    @Operation(summary = "작품 조회", description = "작품1개의 정보."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ArtworkDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/artwork/{artwork_id}")
    public ArtworkDto findArtwork(@PathVariable Integer artwork_id) {
        return artworkService.findArtwork(artwork_id);
    }

//    artwork 리스트 정보 전달
//    /**
//     * 여러개의 아트의 정보 전달(추후 최신)
//     * @List<ArtworkDto>
//     */
//    @ResponseBody
//    @GetMapping("/artwork/lastest")
//
//    public List<ArtworkDto> getArtworkOrderByCreateTimeDesc()
//

//    좋아요 등록
    @ResponseBody
    @PostMapping("saveWishlist")
    public WishlistDto saveWishlist(@RequestBody WishlistDto wishlistDto)
    {
        return wishlistService.saveWishlist(wishlistDto);
    }

    /**
     * 1명의 유저가 좋아요한 리스트
     * @param user_id
     * @return List<ArtworkDto>
     */
    @ResponseBody
    @GetMapping("/artwork/wishlist/{user_id}")
    public List<ArtworkDto> getArtworkByUserId(@PathVariable Integer user_id) {
       return artworkService.getArtworkByUserId(user_id);
    }

//1개의 작품에 좋아요한 갯수

//좋아요 많은 순서대로 필터링한 리스트


//    BuyInfo controller
//1명이 산 구매 리스트 전달
//@ResponseBody
//@GetMapping("/buyinfo")
//public ArtworkDto findArtwork(@RequestBody Integer artwork_id){
//    return artworkService.findArtwork(artwork_id);
//}

//
//1명이 산 특정한 구매 아이템 정보


//    작가가 판매한 아이템 리스트
}
