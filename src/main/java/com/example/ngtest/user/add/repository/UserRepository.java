package com.example.ngtest.user.add.repository;

import com.example.ngtest.user.add.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
//    UserEntity findByUsername(String username);
}
