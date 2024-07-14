package com.basic.mapper;

import com.basic.co.UserCo;
import com.basic.dto.UserDto;
import com.basic.entity.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User coToEntity(UserCo userCo);
    UserDto entityToDto(User user);
    List<UserDto> entityListToDtoList(List<User> user);
    List<User> coListToEntityList(List<UserCo> usersCo);

}
