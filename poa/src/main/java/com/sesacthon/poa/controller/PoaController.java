package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.*;
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
public class PoaController {
    private final UserService userService; // 유저
    private final CreatorService creatorService; // 작가
    private final DisabledService disabledService; // 장애인
    private final FileService fileService; // 파일
    private final ArtworkService artworkService; // 작품

    /**
     * user_id로 유저 조회
     * @param user_id
     * @return UserDto
     */
    @Tag(name = "User", description = "유저")
    @Operation(summary = "유저 조회", description = "일반회원과 작가로 구분됨."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/findUser/{user_id}")
    public UserDto findUser(@PathVariable Integer user_id){
        UserDto userDto = userService.findUser(user_id);
        FileDto fileDto = fileService.findFile(userDto.getProfile());
        if(fileDto!=null)
            userDto.setProfile_url(fileDto.getFile_url());
        return userDto;
    }

    /**
     * 유저 저장
     * @param userDto
     * @return UserDto
     */
    @Tag(name = "User", description = "유저")
    @Operation(summary = "유저 저장", description = "일반회원으로만 저장됨."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping(value = "/saveUser", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserDto saveUser(@RequestPart UserDto userDto, @RequestPart MultipartFile imgFile){
        FileDto fileDto = fileService.saveFile(imgFile);
        userDto.setProfile(fileDto.getFile_id());
        userDto = userService.saveUser(userDto);
        userDto.setProfile_url(fileDto.getFile_url());
        return userDto;
    }

    /**
     * 작가 정보 저장
     * @param reqCreatorDto
     * @return CreatorDto
     */
    @Tag(name = "Creator", description = "작가 정보")
    @Operation(summary = "작가 정보 저장", description = "유저id와 장애 정보id가 필요함.\n유저id 없을시 null 리턴"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CreatorDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveCreator")
    public CreatorDto saveCreator(@RequestBody ReqCreatorDto reqCreatorDto){
        CreatorDto creatorDto = creatorService.saveCreator(reqCreatorDto);
        creatorDto.setUser_id(reqCreatorDto.getUser_id());
        if (!userService.updateUserCreatorId(reqCreatorDto.getUser_id(), creatorDto.getCreator_id())) return null;
        return creatorDto;
    }

    /**
     * 작가 정보 조회
     * @param user_id
     * @return ResCreatorDto
     */
    @Tag(name = "Creator", description = "작가 정보")
    @Operation(summary = "작가 정보 조회", description = "작가정보, 장애정보, 작가작품리스트"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResCreatorDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/findCreator/{user_id}")
    public ResCreatorDto findCreator(@PathVariable Integer user_id){
        ResCreatorDto resCreatorDto = creatorService.findCreator(user_id);
        if(resCreatorDto==null) return null;

        List<ArtworkDto> list = artworkService.findAllByCreatorId(user_id);
        resCreatorDto.setArtworkDtoList(list);
        return resCreatorDto;
    }

    /**
     * 장애 정보 저장
     * @param disabledDto
     * @return
     */
    @Tag(name = "Disabled", description = "장애 정보")
    @Operation(summary = "장애 정보 저장", description = "장애 정보 저장 후 작가 정보 업데이트."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DisabledDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveDisabled")
    public DisabledDto saveDisabled(@RequestBody DisabledDto disabledDto){
        return disabledService.saveDisabled(disabledDto);
    }

    /**
     * 장애 정보 조회
     * @param disabled_id
     * @return DisabledDto
     */
    @Tag(name = "Disabled", description = "장애 정보")
    @Operation(summary = "장애 정보 조회", description = ""
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DisabledDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/findDisabled/{disabled_id}")
    public DisabledDto findDisabled(@PathVariable Integer disabled_id){
        return disabledService.findDisabled(disabled_id);
    }

    /**
     * 장애 정보 전체 조회
     * @return DisabledDto
     */
    @Tag(name = "Disabled", description = "장애 정보")
    @Operation(summary = "장애 정보 전체 조회", description = ""
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DisabledDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping("/findDisabledAll")
    public List<DisabledDto> findDisabledAll(){
        return disabledService.findDisabledAll();
    }

    /**
     * 파일 저장
     * @param imgFile
     * @return FileDto
     */
    @Tag(name = "File", description = "파일")
    @Operation(summary = "파일 저장", description = ""
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = FileDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping(value = "/saveFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileDto saveFile(@RequestPart List<MultipartFile> imgFile){
        return fileService.saveFiles(imgFile);
    }

    /**
     * 파일 조회
     * @param file_id
     * @return FileDto
     */
    @Tag(name = "File", description = "파일")
    @Operation(summary = "파일 조회", description = ""
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = FileDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @GetMapping(value = "/findFile/{file_id}")
    public FileDto findFile(@PathVariable Integer file_id){
        return fileService.findFile(file_id);
    }
}
