package com.sesacthon.poa.controller;

import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.service.PoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Slf4j
public class PoaController {
    private final PoaService poaService;

    @ResponseBody
    @GetMapping("/user")
    public UserDto findUser(){
        return poaService.findUser(1);
    }
}
