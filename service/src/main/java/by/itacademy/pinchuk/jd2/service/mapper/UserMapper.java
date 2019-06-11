package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.UserDto;
import by.itacademy.pinchuk.jd2.database.dto.UserWithCommentsDto;
import by.itacademy.pinchuk.jd2.database.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = Config.class, uses = CommentMapper.class)
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "comments", ignore = true)
    User fromUserDto(UserDto dto);

    UserWithCommentsDto toUserWithCommentsDto(User user);

    User fromUserWithCommentsDto(UserWithCommentsDto dto);
}
