package com.study0912.study0912.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({"/user","/user/"})
@RequiredArgsConstructor
public class UserController {
    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<UserResponseDTO> getUserByUsername(@RequestParam(name = "username") String username){
        UserResponseDTO userResponseDTO = usersService.getByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }
}
