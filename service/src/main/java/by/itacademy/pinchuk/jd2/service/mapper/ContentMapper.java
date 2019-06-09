package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.CommentDto;
import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.dto.ContentTranslationDto;
import by.itacademy.pinchuk.jd2.database.dto.FullContentDto;
import by.itacademy.pinchuk.jd2.database.dto.TagDto;
import by.itacademy.pinchuk.jd2.database.entity.Comment;
import by.itacademy.pinchuk.jd2.database.entity.Content;
import by.itacademy.pinchuk.jd2.database.entity.ContentTranslation;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import by.itacademy.pinchuk.jd2.database.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;

@Mapper(config = Config.class,
        uses = {
                ContentTypeMapper.class,
                CategoryMapper.class,
                UserMapper.class,
                TagMapper.class,
                CommentMapper.class
        })
public interface ContentMapper {

    ContentDto toContentDto(Content content);

    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "tags", ignore = true)
    Content fromContentDto(ContentDto dto);

    FullContentDto toFullContentDto(Content content);

    Content fromFullContentDto(FullContentDto dto);

    Map<Lang, ContentTranslationDto> toTranslationsDto(Map<Lang, ContentTranslation> translations);

    List<CommentDto> toCommentsDto(List<Comment> comments);

    List<TagDto> toTagDto(List<Tag> tags);

    @Mapping(target = "lang", source = "id.lang")
    ContentTranslationDto toContentTranslationDto(ContentTranslation contentTranslation);

    default ContentTranslation fromContentTranslationDto(ContentTranslationDto dto) {
        return ContentTranslation.builder()
                .id(ContentTranslation.ComplexId.builder()
                        .lang(dto.getLang())
                        .build())
                .title(dto.getTitle())
                .introText(dto.getIntroText())
                .fullText(dto.getFullText())
                .metaTitle(dto.getMetaTitle())
                .metaDescription(dto.getMetaDescription())
                .metaKeywords(dto.getMetaKeywords())
                .build();
    }
}
