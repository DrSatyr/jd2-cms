package by.itacademy.pinchuk.jd2.database.dto;

import by.itacademy.pinchuk.jd2.database.entity.Lang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullCategoryDto implements BaseDto<Long> {

    private Long id;
    private FullCategoryDto parentCategory;
    @Builder.Default
    private Set<FullCategoryDto> childCategories = new HashSet<>();
    private String alias;
    private String created;
    private Boolean active;
    @Builder.Default
    private Set<ContentDto> contents = new HashSet<>();
    @Builder.Default
    private Map<Lang, CategoryTranslationDto> translations = new HashMap<>();
}
