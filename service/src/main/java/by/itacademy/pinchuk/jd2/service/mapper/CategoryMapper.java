package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.CategoryDto;
import by.itacademy.pinchuk.jd2.database.dto.CategoryTranslationDto;
import by.itacademy.pinchuk.jd2.database.entity.Category;
import by.itacademy.pinchuk.jd2.database.entity.CategoryTranslation;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Map;

@Mapper(config = Config.class)
public interface CategoryMapper {

    @Mapping(target = "translations", ignore = true)
    CategoryDto toCategoryDto(Category category);

    @Mapping(target = "parentCategory", ignore = true)
    @Mapping(target = "contents", ignore = true)
    @Mapping(target = "childCategories", ignore = true)
    Category fromCategoryDto(CategoryDto dto);

    Map<Lang, CategoryTranslationDto> toCategoryTranslationDtoMap(Map<Lang, CategoryTranslation> translations);
}
