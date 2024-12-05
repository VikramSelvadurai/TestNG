package com.example.ngtest.user.add.service;

import com.example.ngtest.user.add.UserIdNotFoundException;
import com.example.ngtest.user.add.assembler.UserAssembler;
import com.example.ngtest.user.add.entity.UserEntity;
import com.example.ngtest.user.add.repository.ResourceAlreadyExistException;
import com.example.ngtest.user.add.repository.UserRepository;
import com.example.ngtest.user.add.repository.UserRepositoryService;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepositoryService userRepositoryService;
    private final UserRepository userRepository;
    private final UserAssembler userAssembler;

    public UserService(UserRepositoryService userRepositoryService, UserRepository userRepository, UserAssembler userAssembler) {
        this.userRepositoryService = userRepositoryService;
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
    }

    public UserResponseBean addUser(UserRequestBean userRequestBean) throws ResourceAlreadyExistException {
        return userRepositoryService.addUser(userRequestBean);
    }

    public UserResponseBean updateUser(UUID userId, UserRequestBean userRequestBean) throws UserIdNotFoundException, ResourceAlreadyExistException {
        UserEntity userEntity = userRepositoryService.findById(userId);
        if(!userRequestBean.getUsername().isEmpty()){
            if(userRepository.existsByUsernameIgnoreCase(userRequestBean.getUsername())){
                throw new ResourceAlreadyExistException("'"+userRequestBean.getUsername()+"' already exist");
            }
        }

        userEntity.setUsername(userRequestBean.getUsername());
        userEntity.setUserStatus(userRequestBean.getUserStatus());
        userEntity.setEmail(userRequestBean.getEmail());
        userEntity.setFirstName(userRequestBean.getFirstName());
        userEntity.setLastName(userRequestBean.getLastName());
        return userAssembler.toModel(userRepository.save(userEntity));
    }

    public String deleteUser(UUID userId) {
        userRepositoryService.deleteById(userId);
        return "User deleted successfully";
    }

    public UserResponseBean getUserInfo(UUID userId) throws UserIdNotFoundException {
        return userAssembler.toModel(userRepositoryService.findById(userId));
    }
}



