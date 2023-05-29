package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.service.PoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class PoaController {
    private final PoaService poaService; // 추후 서비스 별로 나눠야 함

    /**
     * user_id로 유저 조회
     * @param user_id
     * @return UserDto
     */
    @ResponseBody
    @GetMapping("/user")
    public UserDto findUser(@RequestBody Integer user_id){
        return poaService.findUser(user_id);
    }
}
