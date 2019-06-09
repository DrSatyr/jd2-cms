package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.CommentDto;
import by.itacademy.pinchuk.jd2.database.entity.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = Config.class)
public interface CommentMapper {

    @Mapping(target = "content", ignore = true)
    CommentDto toCommentDto(Comment comment);

    @InheritInverseConfiguration
    Comment fromCommentDto(CommentDto dto);
}
