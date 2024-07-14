package com.basic.service.impl;

import com.basic.co.UserCo;
import com.basic.dto.UserDto;
import com.basic.entity.User;
import com.basic.mapper.UserMapper;
import com.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basic.repository.UserRepository;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserCo userCo) {
        User user=userMapper.coToEntity(userCo);
        user=userRepository.save(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("Could not find user"));
        return userMapper.entityToDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserCo userCo) {
        User user=userMapper.coToEntity(userCo);
        user.setUserId(id);
        user=userRepository.save(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User>userList=userRepository.findAll();
        return userMapper.entityListToDtoList(userList);
    }

    @Override
    public List<UserDto> createAllUsers(List<UserCo> usersCo) {
        List<User> userList=userMapper.coListToEntityList(usersCo);
        userList=userRepository.saveAll(userList);
        return userMapper.entityListToDtoList(userList);
    }
}
