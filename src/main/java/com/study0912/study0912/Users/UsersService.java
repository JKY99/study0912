package com.study0912.study0912.Users;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

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

    public String createUsers(UsersRequestDTO usersRequestDTO){
        Users user = Users.of(null,usersRequestDTO.username(), passwordEncoder.encode(usersRequestDTO.password()), usersRequestDTO.name(),usersRequestDTO.email());

        try{
            usersRepository.save(user);
            return "성공적인듯";
        }catch(Exception e){
            return "ERROR: " + e.getMessage();
        }
    }

}
