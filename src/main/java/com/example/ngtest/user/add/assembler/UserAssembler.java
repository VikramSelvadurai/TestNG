package com.example.ngtest.user.add.assembler;

import com.example.ngtest.user.add.entity.UserEntity;
import com.example.ngtest.user.add.response.UserResponseBean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserAssembler implements RepresentationModelAssembler<UserEntity, UserResponseBean> {
    @Override
    public UserResponseBean toModel(UserEntity entity) {
        UserResponseBean model = buildModel(entity);
        return model;
    }

    private UserResponseBean buildModel(UserEntity entity) {
        return UserResponseBean.builder()
                .userId(entity.getId())
                .username(entity.getUsername())
//                .password(entity.getSourceName())
                .email(entity.getEmail())
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .build();

    }

    @Override
    public CollectionModel<UserResponseBean> toCollectionModel(Iterable<? extends UserEntity> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
