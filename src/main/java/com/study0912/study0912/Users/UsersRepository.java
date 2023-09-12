package com.study0912.study0912.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long>{
    public Optional<Users> findByUsername(String username);
}
