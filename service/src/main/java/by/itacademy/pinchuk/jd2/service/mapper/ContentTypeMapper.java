package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.ContentTypeDto;
import by.itacademy.pinchuk.jd2.database.entity.ContentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = Config.class)
public interface ContentTypeMapper {

    ContentTypeDto toContentTypeDto(ContentType contentType);

    @Mapping(target = "extraFields", ignore = true)
    @Mapping(target = "contents", ignore = true)
    ContentType fromContentTypeDto(ContentTypeDto dto);
}
