package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.*;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class PoaController2 {
    private final ArtworkService artworkService; // 작품
    private final WishlistService wishlistService; // 좋아요
    private final FileService fileService; // 파일
    private final BuyInfoService buyInfoService; // 구매목록

    /**
     * 1개의 아트 정보 저장
     * @param artworkDto
     * @return ArtworkDto
     */
    @Tag(name = "addArtwork", description = "작품 등록")
    @Operation(summary = "작품 저장", description = "작품 저장."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ArtworkDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping(value = "/saveArtwork", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ArtworkDto saveArtwork(@RequestPart ArtworkDto artworkDto, @RequestPart MultipartFile imgFile){
        FileDto fileDto = fileService.saveFile(imgFile);
        artworkDto.setFile_id(fileDto.getFile_id());
        artworkDto = artworkService.saveArtwork(artworkDto);
        artworkDto.setFile_url(fileDto.getFile_url());
        return artworkDto;
    }

    /**
     * 1개의 작품 정보 전달
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
    /**
     * 여러개의 아트의 정보 최신순 전달
     * @List<ArtworkDto>
     */
    @Tag(name = "LastArtworkList", description = "최신작품리스트")
    @Operation(summary = "최신 작품 리스트 조회", description = "최신 작품 여러개의 정보."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = ArtworkDto.class),
                            mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/artwork/last")

    public List<ArtworkDto> findAllDesc(){
        return artworkService.findAllDesc();
    }

    /**
     * 모든 유저가 좋아요한 리스트
     * @return List<ArtworkDto>
     */
    @Tag(name = "Artwork", description = "작품")
    @Operation(summary = "1명의 유저가 좋아요한 작품 리스트 조회", description = "1명의 유저가 좋아요한 여러개의 작품 정보."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ArtworkDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/artwork/wishlist")
    public List<ArtworkDto> getArtworkWishlist() {
        return artworkService.getArtworkWishlist();
    }

//    좋아요 등록
    /**
     * 좋아요(Wishlist) 저장
     * @param wishlistDto
     * @return WishlistDto
     */
    @Tag(name = "Wishlist", description = "좋아요")
    @Operation(summary = "1명의 유저가 1개의 작품에 좋아요 등록", description = "유저id와 작품id 필요."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = WishlistDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("saveWishlist")
    public WishlistDto saveWishlist(@RequestBody WishlistDto wishlistDto)
    {
        return wishlistService.saveWishlist(wishlistDto);
    }

    /**
     * 좋아요 취소
     * @param wishlist_id
     */
    @Tag(name = "Wishlist", description = "좋아요")
    @Operation(summary = "1명의 유저가 1개의 작품에 좋아요 취소", description = "좋아요id 필요."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = WishlistDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("deleteWishlist/{wishlist_id}")
    public void deleteWishlist(@PathVariable Integer wishlist_id)
    {
        wishlistService.deleteWishlist(wishlist_id);
    }

    /**
     * 1명의 유저가 좋아요한 최신순 작품 리스트
     * @param user_id
     * @return List<ArtworkDto>
     */
    @Tag(name = "Wishlist", description = "좋아요")
    @Operation(summary = "1명의 유저가 좋아요한 작품 리스트 최신순 조회", description = "1명의 유저가 좋아요한 여러개의 최신순 작품 정보."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ArtworkDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("findWishlist/{user_id}")
    public List<ArtworkDto> findWishlistByUserId(@PathVariable Integer user_id) {
       return artworkService.findWishlistByUserId(user_id);
    }



//1개의 작품에 좋아요한 갯수

//좋아요 많은 순서대로 필터링한 리스트
//@ResponseBody
//@GetMapping("/artwork/manyWish")
//
//public List<ArtworkDto> findAllCntWishlist(){
//    return artworkService.findAllOrderByWishlist();
//}



//    BuyInfo controller
//    구매정보 등록
    /**
     * 구매 정보 저장
     * @param buyInfoDto
     * @return BuyInfoDto
     */
    @Tag(name = "buyInfoDto", description = "구매 정보")
    @Operation(summary = "구매 정보 저장", description = "구매 정보 저장 후 유저 및 작가 정보, 작품 state 업데이트."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = BuyInfoDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveBuyInfo")
    public BuyInfoDto saveBuyInfo(@RequestBody BuyInfoDto buyInfoDto){
        BuyInfoDto savedBuyInfoDto = buyInfoService.saveBuyInfo(buyInfoDto);
        savedBuyInfoDto.setVisible(buyInfoDto.getVisible());
//        if(!artworkService.updateArtworkVisible(buyInfoDto.getArtwork_id(), savedBuyInfoDto.getVisible())) return null;  artwork_id로 visible을 업데이트 할때
        if(!artworkService.updateArtworkVisibleArtworkState(buyInfoDto.getArtwork_id(), savedBuyInfoDto.getVisible(),0)) return null; // artwork_id로 visible과 artwork_sate를 업데이트 할때

        return buyInfoDto;
    }

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
