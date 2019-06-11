package by.itacademy.pinchuk.jd2.database.dto;

import by.itacademy.pinchuk.jd2.database.entity.Lang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTranslationDto implements BaseDto<CategoryTranslationDto.ComplexId> {

    private ComplexId id;
    private String title;
    private String introText;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;

    @Data
    @Builder
    public static class ComplexId implements Serializable {

        private CategoryDto category;
        private Lang lang;
    }
}
