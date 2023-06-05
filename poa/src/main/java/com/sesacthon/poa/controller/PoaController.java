package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.CreatorDto;
import com.sesacthon.poa.dto.DisabledDto;
import com.sesacthon.poa.dto.FileDto;
import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.service.CreatorService;
import com.sesacthon.poa.service.DisabledService;
import com.sesacthon.poa.service.FileService;
import com.sesacthon.poa.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class PoaController {
    private final UserService userService; // 유저
    private final CreatorService creatorService; // 작가
    private final DisabledService disabledService; // 장애인
    private final FileService fileService; // 파일

    public PoaController(UserService userService, CreatorService creatorService, DisabledService disabledService, FileService fileService) {
        this.userService = userService;
        this.creatorService = creatorService;
        this.disabledService = disabledService;
        this.fileService = fileService;
    }
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
        return userService.findUser(user_id);
    }

    @Tag(name = "User", description = "유저")
    @Operation(summary = "유저 저장", description = "일반회원으로만 저장됨."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @Tag(name = "Creator", description = "작가 정보")
    @Operation(summary = "작가 정보 저장", description = "장애 정보 코드가 필요함."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CreatorDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveCreator")
    public CreatorDto saveCreator(@RequestBody CreatorDto creatorDto){
        return creatorService.saveCreator(creatorDto);
    }

    @Tag(name = "Disabled", description = "장애 정보")
    @Operation(summary = "장애 정보 저장", description = ""
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DisabledDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveDisabled")
    public DisabledDto saveDisabled(@RequestBody DisabledDto disabledDto){
        return disabledService.saveDisabled(disabledDto);
    }

    @Tag(name = "File", description = "파일")
    @Operation(summary = "파일 저장", description = "file_url은 JSON이 저장됨."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserDto.class), mediaType = "application/json"))
    })
    @ResponseBody
    @PostMapping("/saveFile")
    public FileDto saveFile(@RequestBody FileDto fileDto){
        return fileService.saveFile(fileDto);
    }
}
