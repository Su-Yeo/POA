package com.sesacthon.poa.service;

import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.dto.mapper.UserMapper;
import com.sesacthon.poa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PoaService {
    private final UserRepository userRepository; // JPA
    private final UserMapper userMapper; // DTO로 변환

    /**
     * user_id로 유저 조회
     * @param user_id
     * @return UserDto
     */
    public UserDto findUser(Integer user_id){
        return userMapper.toDto(userRepository.findById(user_id).orElse(null));
    }
}
