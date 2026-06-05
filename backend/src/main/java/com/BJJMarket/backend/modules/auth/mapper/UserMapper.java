package com.BJJMarket.backend.modules.auth.mapper;

import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "email", source = "person.email")
    @Mapping(target = "status", source = "UserStatus.name")
    UserResponse toResponse(Users user);
}