package com.BJJMarket.backend.modules.auth.mapper;

import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//Un mapper es una forma de transformar datos
@Mapper(componentModel = "spring")
public interface UserMapper {

    Users toEntity(RegisterRequest dto);
    @Mapping(target = "email", source = "person.email")
    @Mapping(target = "status", source = "userStatus.name")
    //Transforma la entidad ususario a DTO
    UserResponse toDTO(Users user);
    //Transforma la lista de usuario a un dto
    List<UserResponse> toDTOList(List<Users> users);

}