package by.itacademy.pinchuk.jd2.database.dto;

import by.itacademy.pinchuk.jd2.database.entity.Lang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentTranslationDto {

//    private ContentTranslationDto.ComplexIdDto id;
    private Lang lang;
    private String title;
    private String introText;
    private String fullText;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;

//    @Data
//    @Builder
//    public static class ComplexIdDto implements Serializable {
//
//        private ContentDto content;
//        private Lang lang;
//    }
}
