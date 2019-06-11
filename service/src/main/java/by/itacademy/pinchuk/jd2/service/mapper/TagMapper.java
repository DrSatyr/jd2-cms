package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.TagDto;
import by.itacademy.pinchuk.jd2.database.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = Config.class)
public interface TagMapper {

    TagDto toTagDto(Tag tag);

    @Mapping(target = "contents", ignore = true)
    Tag fromTagDto(TagDto tag);
}
