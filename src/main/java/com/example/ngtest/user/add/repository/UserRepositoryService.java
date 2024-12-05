package com.example.ngtest.user.add.repository;

import com.example.ngtest.user.add.UserIdNotFoundException;
import com.example.ngtest.user.add.assembler.UserAssembler;
import com.example.ngtest.user.add.entity.UserEntity;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepositoryService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;

    public UserRepositoryService(UserRepository userRepository, UserAssembler userAssembler) {
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
    }


    public UserResponseBean addUser(UserRequestBean userRequestBean) throws ResourceAlreadyExistException {

        if(userRepository.existsByUsernameIgnoreCase(userRequestBean.getUsername())){
            throw new ResourceAlreadyExistException("User name '"+userRequestBean.getUsername()+"' already exists");
        }

        UserEntity userEntity = UserEntity.builder()
                .username(userRequestBean.getUsername())
                .password(userRequestBean.getPassword())
                .userStatus(userRequestBean.getUserStatus())
                .email(userRequestBean.getEmail())
                .firstName(userRequestBean.getFirstName())
                .lastName(userRequestBean.getLastName())
                .build();
        UserEntity entity = userRepository.save(userEntity);

        return userAssembler.toModel(entity);
    }

    public UserEntity findById(UUID userId) throws UserIdNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        return userEntityOptional.orElseThrow(() -> new UserIdNotFoundException("'"+userId+"' Not Found"));
    }

    public void deleteById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
