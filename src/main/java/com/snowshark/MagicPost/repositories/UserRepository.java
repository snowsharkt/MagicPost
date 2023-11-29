package com.snowshark.MagicPost.repositories;

import com.snowshark.MagicPost.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
