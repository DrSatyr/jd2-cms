package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.CategoryTranslationDto;
import by.itacademy.pinchuk.jd2.database.entity.CategoryTranslation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CategoryMapper.class)
public interface CategoryTranslationMapper {

    @Mapping(target = "id", ignore = true)
    CategoryTranslationDto toCategoryTranslationDto(CategoryTranslation translation);

    @InheritInverseConfiguration
    CategoryTranslation fromCategoryTranslationDto(CategoryTranslationDto translationDto);
}
