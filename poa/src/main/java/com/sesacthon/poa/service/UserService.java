package com.sesacthon.poa.service;

import com.sesacthon.poa.domain.UserEntity;
import com.sesacthon.poa.dto.UserDto;
import com.sesacthon.poa.dto.mapper.UserMapper;
import com.sesacthon.poa.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository; // JPA

    private final UserMapper userMapper; // DTO로 변환

//    public UserService(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }


    /**
     * user_id로 유저 조회
     * @param user_id
     * @return UserDto
     */
    public UserDto findUser(Integer user_id){
        return userMapper.toDto(userRepository.findById(user_id).orElse(null));
    }

    /**
     * 유저 저장
     * @param userDto
     * @return UserDto
     */
    public UserDto saveUser(UserDto userDto){
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(userEntity);
    }
}
