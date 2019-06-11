package by.itacademy.pinchuk.jd2.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto implements BaseDto<Long> {

    private Long id;
    private ContentTypeDto contentType;
    private CategoryDto category;
    private String alias;
    private String created;
    private UserDto createdBy;
    private String lastModified;
    private String publishUp;
    private String publishDown;
    private Integer hits;
    private Boolean active;
    private String extraFields;
    @Builder.Default
    private Set<ContentTranslationDto> translations = new HashSet<>();
}
