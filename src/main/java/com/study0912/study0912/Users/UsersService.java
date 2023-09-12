package com.study0912.study0912.Users;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public UserResponseDTO getByUsername(String username){

        UserResponseDTO userResponseDTO;
        Optional<Users> optionalUser = usersRepository.findByUsername(username);

        if(optionalUser.isPresent()){
            Users user = optionalUser.get();
            userResponseDTO = new UserResponseDTO(user.getUsername(),user.getName(),user.getEmail());
        }else{
            throw new UsernameNotFoundException("ㅎㅎ 못찾음");
        }

        return userResponseDTO;
    }
}
