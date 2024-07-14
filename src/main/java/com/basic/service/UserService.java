package com.basic.service;

import com.basic.co.UserCo;
import com.basic.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    // create
    UserDto createUser(UserCo userCo);

    // findById
    UserDto getUserById(Long id);

    // update
    UserDto updateUser(Long id, UserCo userCo);

    // delete
    void deleteUserById(Long id);

    // findAll
    List<UserDto> getAllUsers();

    // createAll
    List<UserDto> createAllUsers(List<UserCo> usersCo);
}
