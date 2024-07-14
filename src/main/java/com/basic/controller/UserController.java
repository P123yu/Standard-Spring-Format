package com.basic.controller;

import com.basic.co.UserCo;
import com.basic.dto.UserDto;
import com.basic.service.UserService;
import com.basic.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/post")
    public ResponseEntity<ResponseUtil<UserDto>> create(@Valid @RequestBody UserCo userCo){
        UserDto userDto=userService.createUser(userCo);
        ResponseUtil<UserDto> response = ResponseUtil.<UserDto>builder()
                .status(HttpStatus.CREATED.value())
                .success(true).data(userDto)
                .message("User created successfully").build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseUtil<List<UserDto>>> getAllUsers(){
        List<UserDto>usersDto=userService.getAllUsers();
        ResponseUtil<List<UserDto>> response = ResponseUtil.<List<UserDto>>builder()
        .status(HttpStatus.OK.value())
                .success(true).data(usersDto)
                .message("All Users retrieved successfully").build();
        return ResponseEntity.ok(response);
    }



//    @PostMapping("/post")
//    public ResponseEntity<ResponseUtil<Object>> create(@Valid @RequestBody UserCo userCo){
//        UserDto userDto=userService.createUser(userCo);
//        ResponseUtil<Object> response = ResponseUtil.builder().build();
//    }


//    @PostMapping("/post")
//    public ResponseEntity<ResponseUtil<UserDto>> create(@Valid @RequestBody UserCo userCo){
//        UserDto userDto=userService.createUser(userCo);
//        ResponseUtil<UserDto> response = ResponseUtil.<UserDto>builder().build();
//    }


}
